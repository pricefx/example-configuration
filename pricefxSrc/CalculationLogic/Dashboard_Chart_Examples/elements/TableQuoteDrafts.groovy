import net.pricefx.common.api.FieldFormatType
import net.pricefx.domain.Quote
import net.pricefx.server.dto.calculation.ResultMatrix

// Lib
def quoteUtils = libs.Library_Sales.Quotes

def quotes = quoteUtils.getDraftsByYear(year)

return quotesTable("Quote Drafts $year", quotes)

ResultMatrix quotesTable(
        String title,
        List<Quote> quotes
){

    def table = api.newMatrix()
    table.withTitle(title)

    def labels = [
            // typedId should be hidden, because it is only there to be supplied to the matrix action handler
            name       : 'Name',
            label      : 'Label',
            viewQuote  : 'View',
    ]

    def rows = quotes.collect { quote ->
        [
                typedId    : quote.typedId,
                name       : quote.uniqueName,
                label      : quote.label,
                viewQuote  : link("#/qc/quotes/${quote.typedId}", 'View')
        ]
    }

    def columns = labels.keySet() as List<String>
    table.withColumns(columns)
    table.withRows(rows)
    table.withDisableSorting(false)
    table.withEnableClientFilter(true)

    table.rowSelectionBackEndAction('quotes')
            .withLogicName('Handler_SubmitQuotes')
            .withColumns('typedId')
            .withButtonLabel('Submit')
            .withFailureMessage('Failed to approve all selected rows.')
            .withSuccessMessage('Successfully approved all selected quotes.')

    // Add labels, in the backend referred to as "translations"
    labels.each { name, label ->
        table.withColumnTranslation(name, ['': label])
    }

    return table
}

String link(String href, String children) {
    return """<a href="$href">${children}</a>"""
}

Integer getYear() {
    def thisYear = api.calendar().get(Calendar.YEAR)
    return input.year as Integer ?: thisYear
}
