namespace Org.Codecop.Dependencies.D
{
    public class Money
    {
        private readonly decimal value;

        public Money(int value) => this.value = value;

        public Money(decimal value) => this.value = value;

        public Money Percentage(int p)
        {
            return new Money(value * p / 100);
        }

        public string Format()
        {
            return string.Format("{0:0.00}", value);
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
