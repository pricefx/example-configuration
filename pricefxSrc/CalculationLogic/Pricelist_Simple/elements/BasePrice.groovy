def basePrices = api.productExtension("ProductCost")

if(basePrices == null || basePrices.size() == 0) {
  api.addWarning("There is no base price for the product")
  return null
}

if(basePrices.size() > 1) {
  api.addWarning("There is more than one base price for the product")
  return null
}

def base = basePrices.first()?.attribute1

if(base == null) {
  api.addWarning("There is no base price for the product")
}

return base