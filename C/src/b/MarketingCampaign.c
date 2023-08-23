#include <stdint.h>   /* uint64_t */
#include <sys/time.h> /* gettimeofday */
#include <time.h>     /* time */

#include "MarketingCampaign.h"

static int64_t milliSeconds(void)
{
    struct timeval tv;
    gettimeofday(&tv, NULL);
    return (int64_t)tv.tv_sec * 1000 + tv.tv_usec / 1000;
}

bool B_MarketingCampaign_isActive(void)
{
    return milliSeconds() % 2 == 0;
}

static int dayOfWeek(void)
{
    time_t t = time(NULL);
    struct tm* tm_info = localtime(&t);
    return tm_info->tm_wday;
}

bool B_MarketingCampaign_isCrazySalesDay(void)
{
    return dayOfWeek() == 5; // Friday
}
