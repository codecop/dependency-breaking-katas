package org.codecop.dependencies.e;

public class Checkout {

    private final Product product;
    private final EmailService emailService;
    private final UserConfirmation newsLetterSubscribed;
    private final UserConfirmation termsAndConditionsAccepted;

    public Checkout(Product product, EmailService emailService) {
        this.product = product;
        this.emailService = emailService;
        this.newsLetterSubscribed = createUserConfirmation("Subscribe to our product " + product.name() + " newsletter?");
        this.termsAndConditionsAccepted = createUserConfirmation("Accept our terms and conditions?\n" +
                "(Mandatory to place order for " + product.name() + ")");
    }

    protected UserConfirmation createUserConfirmation(String message) {
        return new UserConfirmation(message);
    }

    public void confirmOrder() {
        if (!termsAndConditionsAccepted.isAccepted()) {
            throw new OrderCancelledException(product);
        }

        if (newsLetterSubscribed.isAccepted()) {
            emailService.subscribeUserFor(product);
        }
    }
}
