if (out.InvoicePrice == null
        || out.Quantity == null) {
    api.addWarning("Total Invoice Price cannot be calculated: missing parameter(s)")
    return null
}

return out.InvoicePrice * out.Quantity