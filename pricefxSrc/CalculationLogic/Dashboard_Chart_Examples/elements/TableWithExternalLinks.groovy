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

return tableWithExternalLink(data, labels)

ResultMatrix tableWithExternalLink(
        List<Map> data,
        Map<String, String> labels
) {
    def matrix = api.newMatrix()

    def allLabels = labels + [externalLink: 'External Link']

    matrix.withColumns(allLabels.keySet())

    def rows = data.collect { dataRow ->
        // Add a field to the data set
        dataRow + [
                externalLink: externalLink(
                        "https://duck.com/?q=${urlEncode(dataRow.label)}",
                        "I'm Feeling Lucky"
                )
        ]
    }

    matrix.withRows(rows)

    // Add labels to the columns
    allLabels.each { name, label ->
        matrix.withColumnTranslation(name, ['': label])
    }

    return matrix
}

String externalLink(String href, String children){
    return """<a href="${href}">${children}</a>"""
}

String urlEncode(String str){
    // TODO implement
    return str
}