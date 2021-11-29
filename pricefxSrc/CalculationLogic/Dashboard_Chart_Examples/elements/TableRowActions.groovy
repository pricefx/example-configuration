import net.pricefx.domain.Quote
import net.pricefx.server.dto.calculation.ResultMatrix

// Lib
def quoteUtils = libs.Library_Sales.Quotes

def quotes = quoteUtils.getDraftsByYear(year)

return quotesTable("Quote Drafts $year (Row Action)", quotes)

ResultMatrix quotesTable(
        String title,
        List<Map> quotes
){

    def table = api.newMatrix()
    table.withTitle(title)

    def labels = [
            // typedId should be hidden, because it is only there to be supplied to the matrix action handler
            name       : 'Name',
            label      : 'Label',
            viewQuote  : 'View',
            actions  : 'Actions',
    ]

    def rows = quotes.collect { quote ->
        [
                name       : quote.uniqueName,
                label      : quote.label,
                viewQuote  : link("#/qc/quotes/${quote.typedId}", 'View'),
                actions  : table.cells('Actions', submitAction(table, quote)),
        ]
    }

    def columns = labels.keySet() as List<String>
    table.withColumns(columns)
    table.withRows(rows)
    table.withDisableSorting(false)
    table.withEnableClientFilter(true)

    // Add labels, in the backend referred to as "translations"
    labels.each { name, label ->
        table.withColumnTranslation(name, ['': label])
    }

    return table
}

ResultMatrix.ResultMatrixBackEndCell submitAction(ResultMatrix table, Map quote){
    return table.backEndAction(
            'Submit',
            "/clicmanager.runjob/${quote.typedId}/submit", // Must have leading forward slash
            null,
            "Quote ${quote.uniqueName} was successfully submitted",
            "Failed to submit ${quote.uniqueName}"
    )
}

String link(String href, String children) {
    return """<a href="$href">${children}</a>"""
}

Integer getYear() {
    def thisYear = api.calendar().get(Calendar.YEAR)
    return input.year as Integer ?: thisYear
}
