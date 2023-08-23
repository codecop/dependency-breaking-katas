#include <setjmp.h> /* jmp_buf for mocka */
#include <stdarg.h> /* va_start for mocka */
#include <stddef.h> /* size_t for mocka */

#include <cmocka.h>

#include "../../src/a/Discount.h"
#include "../../src/a/Money.h"

static void test1(void** state)
{
    (void)state; /* unused */
    const A_Money* net = A_Money_createFromInt(1002);

    const A_Money* total = A_Discount_discountFor(net);

    const A_Money* expected = A_Money_createFromLongDouble(901.8);
    assert_true(A_Money_equals(expected, total));

    A_Money_destroy(net);
    A_Money_destroy(total);
    A_Money_destroy(expected);
}

int main(void)
{
    const struct CMUnitTest test_suite[] = {
        cmocka_unit_test(test1), /* */
    };

    return cmocka_run_group_tests(test_suite, NULL, NULL);
}
