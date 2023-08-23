#include <setjmp.h> /* jmp_buf for mocka */
#include <stdarg.h> /* va_start for mocka */
#include <stddef.h> /* size_t for mocka */

#include <cmocka.h>

#include "../src/Hello.h"

static void test_shouldGreet(void** state)
{
    (void)state; /* unused */

    char* greeting = Hello_greeting();

    assert_string_equal("Hello World", greeting);
}

int main(void)
{
    const struct CMUnitTest test_suite[] = {
        cmocka_unit_test(test_shouldGreet), /* */
    };

    return cmocka_run_group_tests(test_suite, NULL, NULL);
}
