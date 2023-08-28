#include <stdlib.h> /* malloc */
#include <string.h> /* strcpy */

#include "Receipt.h"

struct C_Receipt {
    const C_Money* amount;
    const C_Money* tax;
    const C_Money* total;
};

C_Receipt* C_Receipt_create(void)
{
    C_Receipt* receipt = (C_Receipt*)malloc(sizeof(C_Receipt));
    if (receipt != NULL) {
        receipt->amount = NULL;
        receipt->tax = NULL;
        receipt->total = NULL;
    }
    return receipt;
}

void C_Receipt_destroy(C_Receipt* self)
{
    if (self->amount != NULL) {
        C_Money_destroy(self->amount);
    }
    if (self->tax != NULL) {
        C_Money_destroy(self->tax);
    }
    if (self->total != NULL) {
        C_Money_destroy(self->total);
    }
    free(self);
}

const C_Money* C_Receipt_getAmount(const C_Receipt* self)
{
    return self->amount;
}

void C_Receipt_setAmount(C_Receipt* self, const C_Money* amount)
{
    if (self->amount != NULL) {
        C_Money_destroy(self->amount);
    }
    self->amount = amount;
}

const C_Money* C_Receipt_getTax(const C_Receipt* self)
{
    return self->tax;
}

void C_Receipt_setTax(C_Receipt* self, const C_Money* tax)
{
    if (self->tax != NULL) {
        C_Money_destroy(self->tax);
    }
    self->tax = tax;
}

const C_Money* C_Receipt_getTotal(const C_Receipt* self)
{
    return self->total;
}

void C_Receipt_setTotal(C_Receipt* self, const C_Money* total)
{
    if (self->total != NULL) {
        C_Money_destroy(self->total);
    }
    self->total = total;
}

#define LINES 6

char** createFormattedStrings(void)
{
    char** formattedReceipt = (char**)malloc(LINES * sizeof(char*));
    for (int i = 0; i < LINES; i++) {
        formattedReceipt[i] = (char*)malloc((16 + 1) * sizeof(char));
    }
    return formattedReceipt;
}

char** C_Receipt_format(const C_Receipt* self)
{
    char** formattedReceipt = createFormattedStrings();

    strcpy(formattedReceipt[0], "Receipt");
    strcpy(formattedReceipt[1], "=======");
    strcpy(formattedReceipt[2], "Item 1 ... ");
    strcpy(formattedReceipt[3], "Tax    ... ");
    strcpy(formattedReceipt[4], "----------------");
    strcpy(formattedReceipt[5], "Total  ... ");

    C_Money_format(self->amount, formattedReceipt[2] + 11);
    C_Money_format(self->tax, formattedReceipt[3] + 11);
    C_Money_format(self->total, formattedReceipt[5] + 11);

    return formattedReceipt;
}

void C_Receipt_freeFormatted(char** formattedReceipt)
{
    for (int i = 0; i < LINES; i++) {
        free(formattedReceipt[i]);
    }
    free(formattedReceipt);
}
