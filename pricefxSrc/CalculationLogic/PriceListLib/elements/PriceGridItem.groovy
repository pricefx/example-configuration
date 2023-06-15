/**
 * @param priceGridId
 * @param fields Fields to retrieve. This gets passed as an argument to api.find(). Given null, all fields will be retrieved
 * @param callback The closure to be called for each price grid item. The price grid item is passed as a value
 */
void forEach(Long priceGridId, List<String> fields, Closure callback) {
    def filters = [
            Filter.equal("priceGridId", priceGridId)
    ]

    // Iterate with api.find, since api.stream is not implemented in Input Generation mode.
    int startRow = 0
    final maxRows = api.getMaxFindResultsLimit()
    List<Object> rows
    while (rows = api.find("PGI", startRow, maxRows, 'sku', fields, *filters)) {
        rows.each { pgi ->
            callback(pgi)
        }
        startRow += rows.size()
    }
}