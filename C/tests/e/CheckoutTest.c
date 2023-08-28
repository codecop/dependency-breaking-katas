#include <setjmp.h> /* jmp_buf for mocka */
#include <stdarg.h> /* va_start for mocka */
#include <stddef.h> /* size_t for mocka */

#include <cmocka.h>
#include <stdio.h>

#include "../../src/e/Checkout.h"
#include "../../src/e/Product.h"
#include "FakeEmailService.c"

static void test5(void** state)
{
    (void)state; /* unused */
    printf("note for tester:\n");
    printf("* Accept Newsletter\n");
    printf("* Do not Accept Terms\n");

    const E_Product* polkaDotSocks = E_Product_create("Polka-dot Socks");

    E_Checkout* checkout = E_Checkout_create(polkaDotSocks);
    enum E_OrderConfirmation result = E_Checkout_confirmOrder(checkout);

    assert_int_equal(OrderCancelled, result);

    E_Checkout_destroy(checkout);
    E_Product_destroy(polkaDotSocks);
}

int main(void)
{
    const struct CMUnitTest test_suite[] = {
        cmocka_unit_test(test5), /* */
    };

    return cmocka_run_group_tests(test_suite, NULL, NULL);
}
