using System;

namespace Org.Codecop.Dependencies.ParameteriseConstructor
{
    public class MarketingCampaign
    {
        public virtual bool IsActive()
        {
            return DateTime.Now.TimeOfDay.TotalMilliseconds % 2 == 0;
        }

        public virtual bool IsCrazySalesDay()
        {
            return DateTime.Now.DayOfWeek.Equals(DayOfWeek.Friday);
        }
    }
}
