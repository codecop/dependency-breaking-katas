#ifndef E_CHECKOUT_H
#define E_CHECKOUT_H

#include "EmailService.h"
#include "Product.h"
#include "UserConfirmation.h"

typedef struct E_Checkout E_Checkout;

E_Checkout* E_Checkout_create(E_Product* product);
void E_Checkout_destroy(E_Checkout* self);
void E_Checkout_confirmOrder(E_Checkout* self);

#endif // E_CHECKOUT_H
