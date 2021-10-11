if (out.Today > out.EndDate) {
    return out.ActualSales
}

if (out.Today < out.StartDate) {
    return null
}

Integer daysOfLineValidity = out.EndDate - out.StartDate + 1
Integer daysOfTransactions = out.Today - out.StartDate + 1
BigDecimal actualSalesPerDay = out.ActualSales / daysOfTransactions

return actualSalesPerDay * daysOfLineValidity
