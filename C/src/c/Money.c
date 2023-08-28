#include <math.h>   /* fabsl */
#include <stdio.h>  /* sprintf */
#include <stdlib.h> /* malloc */

#include "Money.h"

struct C_Money {
    long double value;
};

const C_Money* C_Money_create(int value)
{
    return C_Money_createFromInternal((long double)value);
}

const C_Money* C_Money_createFromInternal(long double value)
{
    C_Money* money = malloc(sizeof(C_Money));
    if (money != NULL) {
        money->value = value;
    }
    return money;
}

void C_Money_destroy(const C_Money* self)
{
    free((void*)self);
}

const C_Money* C_Money_add(const C_Money* self, const C_Money* other)
{
    return C_Money_createFromInternal(self->value + other->value);
}

const C_Money* C_Money_percentage(const C_Money* self, int p)
{
    return C_Money_createFromInternal(self->value * p / 100);
}

void C_Money_format(const C_Money* self, char* buffer)
{
    sprintf(buffer, "%.2Lf", self->value);
}
