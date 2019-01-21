using System;

namespace Org.Codecop.Dependencies.ParameteriseConstructor
{
    public class Money
    {
        public static readonly Money OneThousand = new Money(1000);

        public static readonly Money OneHoundred = new Money(100);

        private readonly decimal value;

        public Money(int value) => this.value = value;

        public Money(decimal value) => this.value = value;

        public virtual Money ReduceBy(int p)
        {
            return new Money(value * (100m - p) / 100m);
        }

        public virtual bool MoreThan(Money other)
        {
            return this.value.CompareTo(other.value) > 0;
        }

        public override bool Equals(object other)
        {
            if (ReferenceEquals(this, other))
            {
                return true;
            }
            if (ReferenceEquals(null, other) || other.GetType() != this.GetType())
            {
                return false;
            }
            var that = (Money)other;
            return this.value.Equals(that.value);
        }

        public override int GetHashCode()
        {
            return value.GetHashCode();
        }

    }

}
