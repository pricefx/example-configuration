import net.pricefx.domain.Quote
import net.pricefx.server.dto.calculation.ResultMatrix

// Lib
def quoteUtils = libs.Library_Sales.Quotes

def quotes = quoteUtils.getByYear(year)

return quotesTable("Quotes $year", quotes)

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
            quoteStatus: 'Status',
            viewQuote  : 'View',
    ]

    def rows = quotes.collect { quote ->
        [
                typedId    : quote.typedId,
                name       : quote.uniqueName,
                label      : quote.label,
                quoteStatus: getQuoteStatusCell(table, quote.quoteStatus),
                viewQuote  : link("#/qc/quotes/${quote.typedId}", 'Open')
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

def getQuoteStatusCell(ResultMatrix matrix, String quoteStatus) {
    def colors = libs.Library_CSS.Color
    switch (quoteStatus) {
        case 'DEAL':
            return matrix.styledCell(quoteStatus, colors.CONTRAST_TEXT, colors.SUCCESS)
        case 'OFFER':
            return matrix.styledCell(quoteStatus, colors.CONTRAST_TEXT, colors.WARNING)
        case 'LOST':
            return matrix.styledCell(quoteStatus, colors.CONTRAST_TEXT, colors.ERROR)
        default:
            return matrix.styledCell(quoteStatus)
    }
}

Integer getYear() {
    def thisYear = api.calendar().get(Calendar.YEAR)
    return input.year as Integer ?: thisYear
}

String link(String href, String children) {
    return """<a href="$href">${children}</a>"""
}