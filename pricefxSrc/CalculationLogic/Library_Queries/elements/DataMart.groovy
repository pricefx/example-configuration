List getUniqueValues(
        String dataMartName,
        String dimensionColumnName
) {
        def dataSourceAPI = api.getDatamartContext()
        def table = dataSourceAPI.getDatamart(dataMartName)
        def query = dataSourceAPI.newQuery(table, true)
                .select(dimensionColumnName)
                .selectDistinct()

        def results = dataSourceAPI.executeQuery(query)
        return results.getData().toList()[dimensionColumnName]
}