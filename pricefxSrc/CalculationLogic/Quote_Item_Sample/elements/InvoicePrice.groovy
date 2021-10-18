def listPrice = out.ListPrice
def salesDiscountAbs = out.SalesDiscountAbs

if(null in [listPrice, salesDiscountAbs]) {
    api.addWarning("InvoicePrice cannot be calculated due to missing parameter(s)")
    return null
}

return listPrice - salesDiscountAbs