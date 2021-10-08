if (out.ListPrice && out.ProductCost != null) {
    return (out.ListPrice - out.ProductCost) / (out.ListPrice)
} else {
    api.addWarning("Cannot calculate Margin% because ListPrice or ProductCost is not available")
    return null
}