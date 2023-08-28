#ifndef C_MONEY_H
#define C_MONEY_H

typedef struct C_Money C_Money;

const C_Money* C_Money_create(int value);
const C_Money* C_Money_createFromInternal(long double value);
void C_Money_destroy(const C_Money* money);

const C_Money* C_Money_add(const C_Money* self, const C_Money* other);
const C_Money* C_Money_percentage(const C_Money* self, int p);

void C_Money_format(const C_Money* self, char* buffer);

#endif // C_MONEY_H
