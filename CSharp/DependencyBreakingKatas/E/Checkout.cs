namespace Org.Codecop.Dependencies.E
{
    public class Checkout
    {
        private readonly Product product;

        private readonly IEmailService emailService;

        private readonly UserConfirmation newsLetterSubscribed;

        private readonly UserConfirmation termsAndConditionsAccepted;

        public Checkout(Product product, IEmailService emailService)
        {
            this.product = product;
            this.emailService = emailService;
            this.newsLetterSubscribed = new UserConfirmation("Subscribe to our product " + product.Name + " newsletter?");
            this.termsAndConditionsAccepted = new UserConfirmation(
                "Accept our terms and conditions?\n" + //
                "(Mandatory to place order for " + product.Name + ")");
        }

        public virtual void ConfirmOrder()
        {
            if (!termsAndConditionsAccepted.Accepted)
            {
                throw new OrderCancelledException(product);
            }
            if (newsLetterSubscribed.Accepted)
            {
                emailService.SubscribeUserFor(product);
            }
        }
    }
}
