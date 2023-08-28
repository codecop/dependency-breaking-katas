#ifndef A_MONEY_H
#define A_MONEY_H

#include <stdbool.h>

typedef struct A_Money A_Money;

extern const A_Money* ONE_THOUSAND;
extern const A_Money* ONE_HUNDRED;

const A_Money* A_Money_create(int value);
const A_Money* A_Money_createFromInternal(long double value);
void A_Money_destroy(const A_Money* money);

const A_Money* A_Money_reduceBy(const A_Money* self, int p);

bool A_Money_moreThan(const A_Money* self, const A_Money* other);
bool A_Money_equals(const A_Money* self, const A_Money* other);

#endif // A_MONEY_H
