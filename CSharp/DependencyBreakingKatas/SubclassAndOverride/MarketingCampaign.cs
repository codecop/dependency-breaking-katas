using System;

namespace Org.Codecop.Dependencies.SubclassAndOverride
{
    public class MarketingCampaign
    {

        private delegate long TimeSupplier();

        private readonly TimeSupplier SystemTimeMillis;

        public MarketingCampaign()
        {
            this.SystemTimeMillis = () => (long)DateTime.Now.TimeOfDay.TotalMilliseconds;
        }

        public bool IsActive()
        {
            return MilliSeconds() % 2 == 0;
        }

        private long MilliSeconds()
        {
            return this.SystemTimeMillis();
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
