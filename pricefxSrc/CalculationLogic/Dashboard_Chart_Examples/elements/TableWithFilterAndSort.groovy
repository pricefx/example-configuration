import net.pricefx.server.dto.calculation.ResultMatrix

def data = [
        [
                label     : 'Mega Evil Space Cooperation',
                totalSales: 12.8e3,
        ], [
                label     : 'Mom & Pop Store Inc.',
                totalSales: 66.0e3,
        ], [
                label     : 'Academy Toddlers',
                totalSales: 32.2e3,
        ]
]

def labels = [
        label: 'Customer Name',
        totalSales: 'Total Sales (€)',
]

return simpleTableWithSortAndSearch(data, labels)

ResultMatrix simpleTableWithSortAndSearch(
        List<Map> data,
        Map<String, String> labels
) {
    def matrix = api.newMatrix()

    matrix.withColumns(labels.keySet())
    matrix.withRows(data)

    matrix.withDisableSorting(false)
    matrix.withEnableClientFilter(true)

    // Add labels to the columns
    labels.each { name, label ->
        matrix.withColumnTranslation(name, ['': label])
    }

    return matrix
}