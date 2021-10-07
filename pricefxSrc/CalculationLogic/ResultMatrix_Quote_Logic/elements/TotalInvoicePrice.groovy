if (out.Quantity == null || out.InvoicePrice == null) {
    api.addWarning('Cannot be calculated without values for Quantity or InvoicePrice')
    return
}

return out.Quantity * out.InvoicePrice