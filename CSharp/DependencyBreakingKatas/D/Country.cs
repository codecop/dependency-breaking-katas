namespace Org.Codecop.Dependencies.D
{
    public class Country
    {
        private readonly string name;

        public Country(string name) => this.name = name;

        public override string ToString()
        {
            return name;
        }
    }
}
