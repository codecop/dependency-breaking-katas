#include <setjmp.h> /* jmp_buf for mocka */
#include <stdarg.h> /* va_start for mocka */
#include <stddef.h> /* size_t for mocka */

#include <cmocka.h>
#include <stdio.h>

#include "../../src/e/Checkout.h"
#include "../../src/e/Product.h"

void E_EmailService_subscribeUserFor(E_Product* product) {
    // mocked method
}

static void test5(void** state)
{
    (void)state; /* unused */

    printf("note for tester:\n");
    printf("* Accept Newsletter\n");
    printf("* Do not Accept Terms\n");

    E_Product* polkaDotSocks = E_Product_create("Polka-dot Socks");

    E_Checkout* checkout = E_Checkout_create(polkaDotSocks);

    E_Checkout_confirmOrder(checkout);
    // TODO result and must be cancelled

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
