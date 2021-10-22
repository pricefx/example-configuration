if (null in [out.BasePrice, out.MarginAdj, out.AttributeAdj, out.PackagingAdj, out.TaxTariffAdj]) {
    api.addWarning("Cannot calculate ListPrice because some of it's components is not available.")
    return null
}

return out.BasePrice + out.MarginAdj + out.AttributeAdj + out.PackagingAdj + out.TaxTariffAdj