//modified STUB

def basePrice = out.ProductCost  //api.productExtension("ProductCost")?.getAt(0)?.attribute1

if (basePrice == null) {
    api.addWarning("There is no base price for the product")
    return null
}

return basePrice