def taxAdjPct = api.vLookup("TaxAdj", out.Region)

if (null in [taxAdjPct, out.BasePrice]) {
    api.addWarning("Cannot calculate PackagingAdj, because either BasePrice or PackagingAdj %")
    return null
}

return out.BasePrice * taxAdjPct