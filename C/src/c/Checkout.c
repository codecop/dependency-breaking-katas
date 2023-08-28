#include <assert.h>
#include <stdlib.h>

#include "Checkout.h"
#include "ReceiptRepository.h"

C_Receipt* C_Checkout_createReceipt(const C_Money* amount)
{
    if (amount == NULL) {
        return NULL;
    }

    const C_Money* vat = C_Money_percentage(amount, 20.0);

    C_Receipt* receipt = C_Receipt_create();
    if (receipt == NULL) {
        return NULL;
    }

    C_Receipt_setAmount(receipt, amount);
    C_Receipt_setTax(receipt, vat);
    C_Receipt_setTotal(receipt, C_Money_add(amount, vat));

    int result = C_ReceiptRepository_store(receipt);
    assert(result == EXIT_SUCCESS);

    return receipt;
}
