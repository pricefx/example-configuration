/**
 * Calculates expected profitability ( Margin % ) of the given Price List Item (PLI)
 *
 * @param pli Object (as Map) of Pricelist Line Item
 * @return the calculated expected profitability ( Margin % ) of the line
 */
def getMarginPct(pli) {
    def basePrice = pli.calculationResults?.find { it.resultName == "BasePrice" }?.result
    def listPrice = pli.calculationResults?.find { it.resultName == "ListPrice" }?.result
    def marginPct = null
    if (listPrice && basePrice != null) marginPct = (listPrice - basePrice) / listPrice
    return marginPct
}