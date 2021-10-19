if (out.InvoicePrice == null
        || out.Cost == null) {
    api.addWarning("Pocket Margin cannot be calculated: missing parameter(s)")
    return null
}

return out.InvoicePrice - out.Cost