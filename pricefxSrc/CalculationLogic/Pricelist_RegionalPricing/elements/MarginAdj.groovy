def marginAdjPct = api.vLookup("MarginAdj", api.product("ProductGroup"))

if (null in [marginAdjPct, out.BasePrice]) {
    api.addWarning("Cannot calculate MarginAdj, because either BasePrice or MarginAdj %")
    return null
}

return out.BasePrice * marginAdjPct