if (null in [out.InvoicePrice, out.Cost]) {
    api.addWarning("Pocket Margin cannot be calculated due to missing parameter(s)")
    return null
}

return out.InvoicePrice - out.Cost