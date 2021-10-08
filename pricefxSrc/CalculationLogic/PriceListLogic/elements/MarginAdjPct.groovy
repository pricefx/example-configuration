def marginAdjPct = PriceListLib.marginAdj()

if(marginAdjPct == null) {
  api.addWarning("Unable to look up Margin Adjustment with the Product Group")
}

return marginAdjPct