final String FIELD_VOLUME_DISCOUNT = "VolumeDiscount"

def filters = FilterLib.buildFilters("VolumeDiscount", out.ProductId, out.CustomerId)

// more PRs could be available - need to solve conflict. In our case, the higher discount wins
def highestVolumeDiscount = 0.0
def contract = [:]

def iter = api.stream("PR", null, ["sourceId", FIELD_VOLUME_DISCOUNT], *filters)
iter.each { pr ->

    def volumeDiscountTiers = api.jsonDecode(pr[FIELD_VOLUME_DISCOUNT]).collect { [(it.key as BigDecimal), (it.value as BigDecimal)] }
    volumeDiscountTiers.sort { -(it[0]) }

    def discountPct = volumeDiscountTiers.find { out.Quantity >= it[0] }?.getAt(1)

    if (discountPct > highestVolumeDiscount) {
        highestVolumeDiscount = discountPct

        contract.highestVolumeDiscount = highestVolumeDiscount
        contract.selectedContractId = pr.sourceId
    }

}
iter.close()

return contract