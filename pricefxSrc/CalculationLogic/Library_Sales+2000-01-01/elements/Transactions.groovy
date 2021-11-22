import javax.xml.transform.stream.StreamResult

List<Map<String, Object>> getTotalSalesByYear(){
    def dataMartAPI = api.getDatamartContext()

    def table = dataMartAPI.getDatamart("Transaction")

    def query = dataMartAPI.newQuery(table, true)
            .select('InvoiceDateYear')
            .select('SUM(InvoicePrice)', 'TotalSales')
            .orderBy('InvoiceDateYear')

    def result = dataMartAPI.executeQuery(query)
    return result.getData().toList()
}

List<Map<String, Object>> getTotalSalesByYear(BigDecimal totalSalesThreshold){
    def dataMartAPI = api.getDatamartContext()

    def table = dataMartAPI.getDatamart("Transaction")

    def resultFilters = [Filter.greaterOrEqual('TotalSales', totalSalesThreshold)]
    def query = dataMartAPI.newQuery(table, true)
            .select('InvoiceDateYear')
            .select('SUM(InvoicePrice)', 'TotalSales')
            .orderBy('InvoiceDateYear')
            .having(*resultFilters)

    def result = dataMartAPI.executeQuery(query)
    return result.getData().toList()
}

void forEachTransaction(Closure callback){
    def dataMartAPI = api.getDatamartContext()
    def table = dataMartAPI.getDatamart('Transaction')
    def query = dataMartAPI.newQuery(table, false)
            .selectAll()
    def results = dataMartAPI.streamQuery(query)

    // StreamResults is not iterable. Iterate in this non-standard way.
    while(results.next()){
        def row = results.get()
        callback.call(row)
    }

    results.close()
}

BigDecimal getTotalSales(Date dateFrom, Date dateTo){
    def dataMartAPI = api.getDatamartContext()

    def table = dataMartAPI.getDatamart('Transaction')

    def dateFilters = [
            Filter.greaterOrEqual('InvoiceDate', dateFrom),
            Filter.lessThan('InvoiceDate', dateTo),
    ]

    def query = dataMartAPI.newQuery(table, true)
            .select('SUM(InvoicePrice)', 'TotalSales')
            .where(*dateFilters)

    def result = dataMartAPI.executeQuery(query)
    return result.getData().find().TotalSales
}
