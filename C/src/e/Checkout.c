#include <stdlib.h>

#include "Checkout.h"
#include "EmailService.h"
#include "Product.h"
#include "UserConfirmation.h"

struct E_Checkout {
    E_Product* product;
    E_UserConfirmation* newsLetterSubscribed;
    E_UserConfirmation* termsAndConditionsAccepted;
};

E_Checkout* E_Checkout_create(E_Product* product)
{
    E_Checkout* checkout = malloc(sizeof(E_Checkout));
    if (checkout != NULL) {
        checkout->product = product;
        checkout->newsLetterSubscribed =
            E_UserConfirmation_create("Subscribe to our product newsletter?");
        //   new UserConfirmation("Subscribe to our product " + product.name() + " newsletter?");
        checkout->termsAndConditionsAccepted = E_UserConfirmation_create(
            "Accept our terms and conditions?\n" //
            "(Mandatory to place order for the product)");
        // new UserConfirmation("Accept our terms and conditions?\n" +
        // "(Mandatory to place order for " + product.name() + ")");
    }
    return checkout;
}

void E_Checkout_destroy(E_Checkout* self)
{
    if (self != NULL) {
        E_UserConfirmation_destroy(self->newsLetterSubscribed);
        E_UserConfirmation_destroy(self->termsAndConditionsAccepted);
        free(self);
    }
}

void E_Checkout_confirmOrder(E_Checkout* self)
{
    E_UserConfirmation_display(self->termsAndConditionsAccepted);
    if (!E_UserConfirmation_isAccepted(self->termsAndConditionsAccepted)) {
        // TODO Throw OrderCancelledException (not implemented here)
        return;
    }

    E_UserConfirmation_display(self->newsLetterSubscribed);
    if (E_UserConfirmation_isAccepted(self->newsLetterSubscribed)) {
        E_EmailService_subscribeUserFor(self->product);
    }

    // TODO enum with two values OrderConfirmed, OrderCancelled
    return;
}
