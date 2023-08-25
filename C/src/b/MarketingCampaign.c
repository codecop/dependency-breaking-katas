#include <stdint.h>   /* uint64_t */
#include <sys/time.h> /* gettimeofday */
#include <time.h>     /* time */

#include "MarketingCampaign.h"

static struct timeval timeval_now(void)
{
    struct timeval tv;
    gettimeofday(&tv, NULL);
    return tv;
}

bool B_MarketingCampaign_isActive(void)
{
    struct timeval tv = timeval_now();
    return (tv.tv_usec / 1000) % 2 == 0;
}

static struct tm* tm_at_localtime(void)
{
    time_t t = time(NULL);
    return localtime(&t);
}

bool B_MarketingCampaign_isCrazySalesDay(void)
{
    struct tm* tm_info = tm_at_localtime();
    return tm_info->tm_wday == 5; // Friday
}
