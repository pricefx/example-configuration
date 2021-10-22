def productGroup = api.product("ProductGroup")
def marginAdjPct = api.vLookup("MarginAdj", productGroup)

if(marginAdjPct == null) {
  api.addWarning("Unable to look up Margin Adjustment with the Product Group")
}

return marginAdjPct