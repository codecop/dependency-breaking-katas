#include <sys/time.h> /* gettimeofday */
#include <time.h>     /* time */

#include "MarketingCampaign.h"

bool A_MarketingCampaign_isActive(void)
{
    struct timeval tv;
    gettimeofday(&tv, NULL);
    return (tv.tv_usec / 1000) % 2 == 0;
}

bool A_MarketingCampaign_isCrazySalesDay(void)
{
    time_t t = time(NULL);
    struct tm* tm_info = localtime(&t);
    return tm_info->tm_wday == 5; // Friday;
}
