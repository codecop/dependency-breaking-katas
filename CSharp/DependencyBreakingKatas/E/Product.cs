namespace Org.Codecop.Dependencies.E
{
    public class Product
    {

        public string Name { get; private set; }

        public Product(string name) => this.Name = name;

        public override string ToString()
        {
            return Name;
        }
    }
}
