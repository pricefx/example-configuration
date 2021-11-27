import net.pricefx.common.api.FieldFormatType
import net.pricefx.server.dto.calculation.ResultMatrix

def data = [
        [
                customerId: 'CD-00001',
                label     : 'Mega Evil Space Cooperation',
                totalSales: 12.8e3,
        ], [
                customerId: 'CD-00001',
                label     : 'Mom & Pop Store Inc.',
                totalSales: 66.0e3,
        ], [
                customerId: 'CD-00001',
                label     : 'Academy Toddlers',
                totalSales: 32.2e3,
        ]
]

def labels = [
        // Do not include the customerId
        label     : 'Customer Name',
        totalSales: 'Total Sales (€)',
]

return simpleTable(data, labels)

ResultMatrix simpleTable(
        List<Map> data,
        Map<String, String> labels
) {
    def matrix = api.newMatrix()

    matrix.withColumns(labels.keySet())
    matrix.withRows(data)

    // Add labels to the columns
    labels.each { name, label ->
        matrix.withColumnTranslation(name, ['': label])
    }

    return matrix
}