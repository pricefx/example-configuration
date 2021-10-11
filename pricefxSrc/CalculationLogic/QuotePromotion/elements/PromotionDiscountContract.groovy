final String FIELD_PROMOTION_DISCOUNT = "PromotionDiscount"

def filters = FilterLib.buildFilters("PromotionDiscount", out.ProductId, out.CustomerId)

// more PRs could be available - need to solve conflict. In our case, the higher discount wins
def highestPromotionDiscount = 0.0
def contract = [:]

def iter = api.stream("PR", null, ["sourceId", FIELD_PROMOTION_DISCOUNT], *filters)
iter.each { pr ->

    def discountPct = pr[FIELD_PROMOTION_DISCOUNT] as BigDecimal

    if (discountPct > highestPromotionDiscount) {
        highestPromotionDiscount = discountPct

        contract.highestPromotionDiscount = highestPromotionDiscount
        contract.selectedContractId = pr.sourceId
    }

}
iter.close()

return contract