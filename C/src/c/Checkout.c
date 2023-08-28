#include "Checkout.h"

#include "ReceiptRepository.h"

C_Receipt* C_Checkout_createReceipt(const C_Money* amount)
{
    const C_Money* vat = C_Money_percentage(amount, 20.0);

    C_Receipt* receipt = C_Receipt_create();
    C_Receipt_setAmount(receipt, amount);
    C_Receipt_setTax(receipt, vat);
    C_Receipt_setTotal(receipt, C_Money_add(amount, vat));

    C_ReceiptRepository_store(receipt);

    return receipt;
}
