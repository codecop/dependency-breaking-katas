#include <math.h>   /* fabsl */
#include <stdlib.h> /* malloc */

#include "Money.h"

struct A_Money {
    long double value;
};

const A_Money* ONE_THOUSAND = &((struct A_Money){1000.0});
const A_Money* ONE_HUNDRED = &((struct A_Money){100.0});

const A_Money* A_Money_create(int value)
{
    return A_Money_createFromInternal((long double)value);
}

const A_Money* A_Money_createFromInternal(long double value)
{
    A_Money* money = malloc(sizeof(A_Money));
    if (money != NULL) {
        money->value = value;
    }
    return money;
}

void A_Money_destroy(const A_Money* self)
{
    free((void*)self);
}

const A_Money* A_Money_reduceBy(const A_Money* self, int p)
{
    return A_Money_createFromInternal(self->value * (100 - p) / 100);
}

bool A_Money_moreThan(const A_Money* self, const A_Money* other)
{
    return self->value > other->value;
}

bool A_Money_equals(const A_Money* self, const A_Money* other)
{
    return fabsl(self->value - other->value) < 1E-9; // or LDBL_EPSILON;
}
