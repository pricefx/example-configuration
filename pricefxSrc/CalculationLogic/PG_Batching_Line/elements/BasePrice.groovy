def basePrice = api.productExtension("ProductCost")?.find()?.attribute1

if (basePrice == null) {
    api.addWarning("There is no base price for the product")
    return null
}

return basePrice