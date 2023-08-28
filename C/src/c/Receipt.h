#ifndef C_RECEIPT_H
#define C_RECEIPT_H

#include "Money.h"

typedef struct C_Receipt C_Receipt;

C_Receipt* C_Receipt_create(void);
void C_Receipt_destroy(C_Receipt* receipt);

const C_Money* C_Receipt_getAmount(const C_Receipt* self);
void C_Receipt_setAmount(C_Receipt* self, const C_Money* amount);

const C_Money* C_Receipt_getTax(const C_Receipt* self);
void C_Receipt_setTax(C_Receipt* self, const C_Money* tax);

const C_Money* C_Receipt_getTotal(const C_Receipt* self);
void C_Receipt_setTotal(C_Receipt* self, const C_Money* total);

char** C_Receipt_format(const C_Receipt* self);

void C_Receipt_freeFormatted(char** formattedReceipt);

#endif // C_RECEIPT_H
