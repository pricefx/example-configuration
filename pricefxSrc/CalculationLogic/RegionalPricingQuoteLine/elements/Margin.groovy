if (null in [out.InvoicePrice, out.Cost]) {
    api.addWarning("Cannot calculate Margin, because either InvoicePrice or Cost is not available.")
    return null
}

return (out.InvoicePrice - out.Cost)