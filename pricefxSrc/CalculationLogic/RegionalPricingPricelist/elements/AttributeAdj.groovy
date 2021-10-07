def attributeAdjPct = api.vLookup("AttributeAdj", "AttributeAdj", api.product("ProductLifeCycle"))

if (null in [attributeAdjPct, out.BasePrice]) {
    api.addWarning("Cannot calculate AttributeAdj, because either BasePrice or AttributeAdj %")
    return null
}

return out.BasePrice * attributeAdjPct