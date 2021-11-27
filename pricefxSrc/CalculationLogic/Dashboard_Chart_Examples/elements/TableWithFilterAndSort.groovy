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
    def table = api.newMatrix()

    table.withColumns(labels.keySet())
    table.withRows(data)

    table.withDisableSorting(false)
    table.withEnableClientFilter(true)

    // Add labels to the columns
    labels.each { name, label ->
        table.withColumnTranslation(name, ['': label])
    }

    return table
}