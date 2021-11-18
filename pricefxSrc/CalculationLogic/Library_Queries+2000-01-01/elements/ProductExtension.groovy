import com.googlecode.genericdao.search.Filter

List<Map<String, Object>> find(
        String tableName,
        int startRow,
        int maxRows,
        String sortBy,
        List<String> fields,
        Filter... filters
) {
    def tableFilter = Filter.equal('customerId', tableName)
    return api.find(
            'CX',
            startRow,
            maxRows,
            sortBy,
            fields,
            tableFilter,
            *filters
    ) as List<Map<String, Object>>
}