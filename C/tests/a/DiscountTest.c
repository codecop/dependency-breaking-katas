#include <setjmp.h> /* jmp_buf for mocka */
#include <stdarg.h> /* va_start for mocka */
#include <stddef.h> /* size_t for mocka */

#include <cmocka.h>

#include "../../src/a/Discount.h"

static void test1(void** state)
{
    (void)state; /* unused */
    const A_Money* net = A_Money_create(1002);
    const A_Discount* discount = A_Discount_make(0.1);

    const A_Money* total = A_Discount_discountFor(discount, net);

    const A_Money* expected = A_Money_createFromInternal(901.8);
    assert_true(A_Money_equals(expected, total));

    A_Money_destroy(net);
    A_Money_destroy(total);
    A_Money_destroy(expected);
    A_Discount_destroy(discount);
}

int main(void)
{
    const struct CMUnitTest test_suite[] = {
        cmocka_unit_test(test1), /* */
    };

    return cmocka_run_group_tests(test_suite, NULL, NULL);
}
