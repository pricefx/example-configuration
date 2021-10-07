if (null in [out.Quantity, out.InvoicePrice]) {
    api.addWarning("Cannot calculate Total Invoice Price because either Quanity or Invoice Price is not available.")
    return null
}

return out.Quantity * out.InvoicePrice