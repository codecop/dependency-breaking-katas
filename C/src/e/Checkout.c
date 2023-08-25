#include <stdio.h>  /* sprintf */
#include <stdlib.h> /* malloc */

#include "Checkout.h"
#include "EmailService.h"
#include "Product.h"
#include "UserConfirmation.h"

struct E_Checkout {
    const E_Product* product;
    E_UserConfirmation* newsLetterSubscribed;
    E_UserConfirmation* termsAndConditionsAccepted;
};

E_Checkout* E_Checkout_create(const E_Product* product)
{
    E_Checkout* checkout = malloc(sizeof(E_Checkout));
    if (checkout != NULL) {
        checkout->product = product;
        char message[256];
        sprintf(message, "%s%s%s", //
                 "Subscribe to our product ", E_Product_name(product),
                " newsletter?");
        checkout->newsLetterSubscribed = E_UserConfirmation_create(message);
        sprintf(message, "%s%s%s", //
                "Accept our terms and conditions?\n(Mandatory to place order for ",
                E_Product_name(product), ")");
        checkout->termsAndConditionsAccepted = E_UserConfirmation_create(message);
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

enum E_OrderConfirmation E_Checkout_confirmOrder(E_Checkout* self)
{
    E_UserConfirmation_display(self->termsAndConditionsAccepted);
    if (!E_UserConfirmation_isAccepted(self->termsAndConditionsAccepted)) {
        return OrderCancelled;
    }

    E_UserConfirmation_display(self->newsLetterSubscribed);
    if (E_UserConfirmation_isAccepted(self->newsLetterSubscribed)) {
        E_EmailService_subscribeUserFor(self->product);
    }

    return OrderConfirmed;
}
