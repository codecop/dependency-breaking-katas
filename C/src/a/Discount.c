#include <stdlib.h> /* NULL */

#include "Discount.h"
#include "MarketingCampaign.h"

struct A_Discount {
    long double something;
};

const A_Discount* A_Discount_make(const long double something)
{
    A_Discount* discount = (A_Discount*)malloc(sizeof(A_Discount));
    if (discount != NULL) {
        discount->something = something;
    }
    return discount;
}

void A_Discount_destroy(const A_Discount* this)
{
    free((void*)this);
}

const A_Money* A_Discount_discountFor(const A_Discount* this, const A_Money* netPrice)
{
    (void)this; /* assume we do something */

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
