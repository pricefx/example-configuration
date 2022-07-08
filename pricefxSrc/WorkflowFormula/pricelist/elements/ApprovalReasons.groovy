/* "pricelist" binding variable is provided by the calculation engine */
def table = api.findLookupTable("PricelistApprovalLevels")
def reasons = []

def pliIterator = api.stream("PLI", "sku", Filter.equal("pricelistId", pricelist.id))
pliIterator.each { pli ->
    def marginPct = Helper.getMarginPct(pli)
    def businessUnit = api.product("BusinessUnit", pli.sku)

    def row = api.find("MLTV", 0, 1, null,
            Filter.equal("lookupTable.id", table?.id),
            Filter.equal("name", businessUnit)
    )?.getAt(0)
    def marginThresholdPct = row?.attribute1

    if (marginPct == null) {
        reasons.add("SKU ${pli.sku}: Cannot evaluate expected profitability")
    } else if (marginThresholdPct != null && marginPct < marginThresholdPct) {
        reasons.add("SKU ${pli.sku}: has margin $marginPct below the threshold $marginThresholdPct")
    }
}
pliIterator.close()

return reasons