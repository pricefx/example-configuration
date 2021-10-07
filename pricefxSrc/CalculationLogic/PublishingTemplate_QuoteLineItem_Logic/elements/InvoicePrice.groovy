if (out.ListPrice == null ||
        out.SalesDiscountAbs == null) {
    api.addWarning("InvoicePrice cannot be calculated: missing ListPrice or SalesDiscount")
    return null
}

return out.ListPrice - out.SalesDiscountAbs