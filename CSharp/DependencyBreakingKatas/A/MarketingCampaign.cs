using System;

namespace Org.Codecop.Dependencies.A
{
    public class MarketingCampaign
    {
        public bool IsActive()
        {
            return (long) DateTime.Now.TimeOfDay.TotalMilliseconds % 2 == 0;
        }

        public bool IsCrazySalesDay()
        {
            return DateTime.Now.DayOfWeek.Equals(DayOfWeek.Friday);
        }
    }
}
