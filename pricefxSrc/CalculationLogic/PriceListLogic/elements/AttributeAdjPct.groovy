def attributeAdjPct = PriceListLib.attributeAdj()

if(attributeAdjPct == null) {
  api.addWarning("Unable to look up Attribute Adjustment with the Product Life Cycle")
}

return attributeAdjPct