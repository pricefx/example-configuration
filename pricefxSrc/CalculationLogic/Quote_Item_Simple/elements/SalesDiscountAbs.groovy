if (out.ListPrice == null ||
        out.SalesDiscountPct == null) {
    api.addWarning("Sales Discount cannot be calculated: missing parameter(s)")
    return null
}

return out.ListPrice * out.SalesDiscountPct