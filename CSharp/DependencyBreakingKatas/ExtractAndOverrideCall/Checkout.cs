namespace Org.Codecop.Dependencies.ExtractAndOverrideCall
{
    public class Checkout
    {
        public Receipt CreateReceipt(Money amount)
        {
            var receipt = new Receipt();
            var vat = amount.Percentage(20);

            receipt.Amount = amount;
            receipt.Tax = vat;
            receipt.Total = amount.Add(vat);

            ReceiptRepository.Store(receipt);

            return receipt;
        }
    }
}
