def priceGridId = Lib.getPriceGridId()

// Reading header inputs from the header. This has to be done in a special way, thus we use a library function.
// Because the input generation and actual calculation are both performed in Input Generation mode, we need to ensure that
// the execution never fails due to missing inputs, or we won't be able to generate those very inputs
def priceListHeaderInputs = libs.PriceListHeaderLib.Input
def specialAdjPctInputValue = priceListHeaderInputs['SpecialAdjPct'] ?: 0

if (priceGridId) {
    api.setPricegridCalculationOutput(priceGridId, "specialAdjPct", "Special Adj %",
            "${api.formatNumber('#,##0.00%', specialAdjPctInputValue)}"
            , null)
    api.setPricegridCalculationOutput(priceGridId, "sumListPrice", "Sum List Price",
            "€ ${api.formatNumber('#,##0.00', out.Summary.sumListPrice)}",
            null)
    api.setPricegridCalculationOutput(priceGridId, "sumCost", "Sum Cost",
            "€ ${api.formatNumber('#,##0.00', out.Summary.sumCost)}",
            null)
    api.setPricegridCalculationOutput(priceGridId, "sumGrossMargin", "Sum Gross Margin",
            "€ ${api.formatNumber('#,##0.00', out.Summary.sumGrossMargin)}",
            null)
}
