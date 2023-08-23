#include <stdlib.h> /* NULL */

#include "Discount.h"
#include "MarketingCampaign.h"

const A_Money* A_Discount_discountFor(const A_Money* netPrice)
{
    if (netPrice == NULL) {
        return NULL;
    }

    if (A_MarketingCampaign_isCrazySalesDay()) {
        return A_Money_reduceBy(netPrice, 15);
    }
    if (A_Money_moreThan(netPrice, ONE_THOUSAND)) {
        return A_Money_reduceBy(netPrice, 10);
    }
    if (A_Money_moreThan(netPrice, ONE_HUNDRED) && A_MarketingCampaign_isActive()) {
        return A_Money_reduceBy(netPrice, 5);
    }

    return A_Money_reduceBy(netPrice, 0); // force copy
}
