#ifndef E_CHECKOUT_H
#define E_CHECKOUT_H

#include "EmailService.h"
#include "Product.h"
#include "UserConfirmation.h"

enum E_OrderConfirmation { OrderConfirmed, OrderCancelled };

typedef struct E_Checkout E_Checkout;

E_Checkout* E_Checkout_create(const E_Product* product);
void E_Checkout_destroy(E_Checkout* self);

enum E_OrderConfirmation E_Checkout_confirmOrder(E_Checkout* self);

#endif // E_CHECKOUT_H
