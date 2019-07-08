namespace Org.Codecop.Dependencies.C
{
    public class Money
    {
        private readonly decimal value;

        public Money(int value) => this.value = value;

        public Money(decimal value) => this.value = value;

        public Money Add(Money other)
        {
            return new Money(value + other.value);
        }

        public Money Percentage(int p)
        {
            return new Money(value * p / 100);
        }

        public string Format()
        {
            return string.Format("{0:0.00}", value);
        }

        internal decimal AsDecimal()
        {
            return value;
        }
    }
}
