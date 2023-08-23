#include <setjmp.h> /* jmp_buf for mocka */
#include <stdarg.h> /* va_start for mocka */
#include <stddef.h> /* size_t for mocka */

#include <cmocka.h>

#include "../../src/b/MarketingCampaign.h"

static void test2(void** state)
{
    (void)state; /* unused */

    bool isCrazySalesDay = B_MarketingCampaign_isCrazySalesDay();

    assert_false(isCrazySalesDay);
}

int main(void)
{
    const struct CMUnitTest test_suite[] = {
        cmocka_unit_test(test2), /* */
    };

    return cmocka_run_group_tests(test_suite, NULL, NULL);
}
