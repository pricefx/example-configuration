if (null in [out.ListPrice, out.BasePrice]) {
    api.addWarning("Cannot calculate GrossMargin, because either ListPrice or BasePrice is not available.")
    return null
}

if (out.ListPrice == 0){
    return null
}

BigDecimal grossMargin = (out.ListPrice - out.BasePrice) / out.ListPrice

if(grossMargin <= out.GrossMarginThreshold){
    api.redAlert("Gross margin (${grossMargin}) is less than the threshold (${out.GrossMarginThreshold})")
}

return grossMargin