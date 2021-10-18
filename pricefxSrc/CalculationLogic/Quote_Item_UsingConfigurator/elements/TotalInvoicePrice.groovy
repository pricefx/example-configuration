//added only a part to STUB

if (out.InvoicePrice == null
        || out.Quantity == null
        || out.FreightSurcharge == null) {
    api.addWarning("Total Invoice Price cannot be calculated: missing InvoicePrice, Quantity or FreightSurcharge.")
    return null
}

return out.InvoicePrice * out.Quantity + out.FreightSurcharge