if (null in [out.ListPrice, out.InvoicePrice]) {
    api.addWarning("Cannot calculate Sales Discount, because either ListPrice or InvoicePrice is unavailable")
    return null
}

if (out.ListPrice == 0) {
    api.addWarning("Cannot calculate Sales Discount, because List Price is 0")
    return
}

BigDecimal salesDiscountPct = (out.ListPrice - out.InvoicePrice) / out.ListPrice

BigDecimal salesDiscountThresholdCritical = api.vLookup("SalesDiscountThreshold", "CriticalAlert", out.Region, out.BusinessUnit)
BigDecimal salesDiscountThresholdRed = api.vLookup("SalesDiscountThreshold", "RedAlert", out.Region, out.BusinessUnit)
BigDecimal salesDiscountThresholdYellow = api.vLookup("SalesDiscountThreshold", "YellowAlert", out.Region, out.BusinessUnit)

if (salesDiscountThresholdCritical && salesDiscountPct >= salesDiscountThresholdCritical) {
    api.criticalAlert("Discount Unacceptable")
} else if (salesDiscountThresholdRed && salesDiscountPct >= salesDiscountThresholdRed) {
    api.redAlert("Discount Too High")
} else if (salesDiscountThresholdYellow && salesDiscountPct >= salesDiscountThresholdYellow) {
    api.yellowAlert("High Discount")
}

return salesDiscountPct