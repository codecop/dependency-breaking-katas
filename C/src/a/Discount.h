#ifndef A_DISCOUNT_H
#define A_DISCOUNT_H

#include "Money.h"

typedef struct A_Discount A_Discount;

const A_Discount* A_Discount_make(const long double something);

const A_Money* A_Discount_discountFor(const A_Discount* this, const A_Money* netPrice);

void A_Discount_destroy(const A_Discount* this);

#endif // A_DISCOUNT_H
