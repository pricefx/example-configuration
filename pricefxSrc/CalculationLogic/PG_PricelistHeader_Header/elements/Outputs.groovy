def pgId = out.CurrentItem?.id

//reading header inputs on the header itself
def specialAdjPctInputValue = api.jsonDecode(out.CurrentItem["configuration"])
        ?.headerInputs.find { it.name == "SpecialAdjPct" }
        ?.value ?: 0.0

if (pgId) {
    api.setPricegridCalculationOutput(pgId, "specialAdjPct", "Special Adj %",
            "${api.formatNumber('#,##0.00%', specialAdjPctInputValue)}"
            , null)
    api.setPricegridCalculationOutput(pgId, "sumListPrice", "Sum List Price",
            "€ ${api.formatNumber('#,##0.00', out.Summary.sumListPrice)}",
            null)
    api.setPricegridCalculationOutput(pgId, "sumCost", "Sum Cost",
            "€ ${api.formatNumber('#,##0.00', out.Summary.sumCost)}",
            null)
    api.setPricegridCalculationOutput(pgId, "sumGrossMargin", "Sum Gross Margin",
            "€ ${api.formatNumber('#,##0.00', out.Summary.sumGrossMargin)}",
            null)
}
