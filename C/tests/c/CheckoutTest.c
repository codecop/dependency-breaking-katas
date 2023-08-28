#include <setjmp.h> /* jmp_buf for mocka */
#include <stdarg.h> /* va_start for mocka */
#include <stddef.h> /* size_t for mocka */

#include <cmocka.h>

#include "../../src/c/Checkout.h"

static void test3(void** state)
{
    (void)state; /* unused */
    const C_Money* amount = C_Money_create(12);

    C_Receipt* receipt = C_Checkout_createReceipt(amount);

    assert_non_null(receipt);

    C_Receipt_destroy(receipt); // also destroys amount
}

int main(void)
{
    const struct CMUnitTest test_suite[] = {
        cmocka_unit_test(test3), /* */
    };

    return cmocka_run_group_tests(test_suite, NULL, NULL);
}
