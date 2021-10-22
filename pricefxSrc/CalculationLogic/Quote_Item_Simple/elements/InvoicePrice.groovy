if (out.ListPrice == null ||
        out.SalesDiscountAbs == null) {
    api.addWarning("InvoicePrice cannot be calculated: missing parameter(s)")
    return null
}

return out.ListPrice - out.SalesDiscountAbs