if (null in [out.InvoicePrice, out.Margin]) {
    api.addWarning("Cannot calculate Margin %, because either InvoicePrice or Margin is not available.")
    return null
}

if (out.InvoicePrice == 0) return null

return out.Margin / out.InvoicePrice