if (out.ListPrice != null && out.Cost != null) {
    return (out.ListPrice - out.Cost) / out.ListPrice
} else {
    api.addWarning("Cannot calculate the Gross Margin, because either ListPrice or Cost is not available.")
    return null
}
