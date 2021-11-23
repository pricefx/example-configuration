/**
 * Get the total sales by reading from the price records table
 * @param fromDate
 * @param toDate
 * @return the total sales in the specified time period, in EUR.
 */
BigDecimal getTotalSales(
        Date fromDate,
        Date toDate = new Date()
) {
    String fromString = fromDate.format('yyyy-MM-dd')
    String toString = toDate.format('yyyy-MM-dd')
    def filter = Filter.and(
            Filter.greaterOrEqual('validAfter', fromDate),
            Filter.lessOrEqual('validAfter', toDate)
    )
    api.find('PR', 0, 1, null, [attribute1: 'SUM'], false, filter).find()?.attribute1
}