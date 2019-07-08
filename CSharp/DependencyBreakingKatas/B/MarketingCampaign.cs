using System;

namespace Org.Codecop.Dependencies.B
{
    public class MarketingCampaign
    {

        public bool IsActive()
        {
            return MilliSeconds() % 2 == 0;
        }

        private long MilliSeconds()
        {
            return (long) DateTime.Now.TimeOfDay.TotalMilliseconds;
        }

        public bool IsCrazySalesDay()
        {
            return DayOfTheWeek().Equals(DayOfWeek.Friday); ;
        }

        private DayOfWeek DayOfTheWeek()
        {
            return DateTime.Now.DayOfWeek;
        }
    }
}
