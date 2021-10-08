def invoicePrice = out.InvoicePrice
def cost = out.Cost

// Add null checks
if(null in [invoicePrice, cost]) {
    api.addWarning("Pocket Margin cannot be calculated due to missing parameter(s)")
    return null
}

return invoicePrice - cost