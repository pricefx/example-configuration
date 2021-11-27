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

return tableWithCustomerDetail(data, labels)

ResultMatrix tableWithCustomerDetail(
        List<Map> data,
        Map<String, String> labels
) {
    def table = api.newMatrix()

    def allLabels = labels + [openCustomerDetail: 'Customer Detail']

    table.withColumns(allLabels.keySet())

    def rows = data.collect { dataRow ->
        // Add a field to the data set
        dataRow + [
                openCustomerDetail: customerDetailLink(table, dataRow.customerId as String)
        ]
    }

    table.withRows(rows)

    // Add labels to the columns
    allLabels.each { name, label ->
        table.withColumnTranslation(name, ['': label])
    }

    return table
}

String customerDetailLink(ResultMatrix matrix, String customerId){
    // If customerId is null, the customer master table screen would open
    if(customerId == null){
        throw new Exception('customerId must be provided')
    }
    return matrix.linkCell('Customer Detail', 'customersPage', customerId)
}
