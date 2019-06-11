namespace Org.Codecop.Dependencies.D
{
    public class ShippingCost
    {
        public Money Calculate(Country country, DeliveryOptions options)
        {
            Money cost;
            if (RestCountriesAPI.GetInstance().IsInCommonMarket(country))
            {
                // flat rate in EU
                cost = new Money(5);
            }
            else
            {
                if (RestCountriesAPI.GetInstance().IsInAmericas(country))
                {
                    // US & Canada & South American
                    if (options == DeliveryOptions.Express)
                    {
                        cost = new Money(40);
                    }
                    else
                    {
                        cost = new Money(15);
                    }
                }
                else
                {
                    // other countries, e.g. Asia
                    var km = RestCountriesAPI.GetInstance().DistanceTo(country);
                    cost = new Money(km).Percentage(10);
                }
            }
            return cost;
        }
    }
}
