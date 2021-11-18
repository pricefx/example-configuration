import com.googlecode.genericdao.search.Filter

List<Map<String, Object>> find(
        String tableName,
        int startRow,
        int maxRows,
        String sortBy,
        List<String> fields,
        Filter... filters
) {
    def tableFilter = Filter.equal('name', tableName)
    return api.find(
            'PX',
            startRow,
            maxRows,
            sortBy,
            fields,
            tableFilter,
            *filters
    ) as List<Map<String, Object>>
}