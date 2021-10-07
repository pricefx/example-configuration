def packagingAdjPct = api.vLookup("PackagingAdj", "PackagingAdj", api.product("Size"))

if (null in [packagingAdjPct, out.BasePrice]) {
    api.addWarning("Cannot calculate AttributeAdj, because either BasePrice or AttributeAdj %")
    return null
}

return out.BasePrice * packagingAdjPct