import net.pricefx.common.api.FieldFormatType
import net.pricefx.domain.Quote
import net.pricefx.server.dto.calculation.ResultMatrix

def quotes = findQuotes()

def matrix = api.newMatrix()

labels = [
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
            quoteStatus: getStatusCell(matrix, quote.quoteStatus),
            viewQuote  : link("#/qc/quotes/${quote.typedId}", 'View')
    ]
}

def columns = labels.keySet() as List<String>
matrix.withColumns(columns)
matrix.withRows(rows)
matrix.withTitle("Quotes $year")
matrix.withDisableSorting(false)
matrix.withEnableClientFilter(true)

matrix.rowSelectionBackEndAction("selectedQuotes")
        .withLogicName("Handler_SubmitQuotes")
        .withColumns('typedId')
        .withButtonLabel("Submit")
        .withFailureMessage("Failed to approve all selected rows.")
        .withSuccessMessage("Successfully approved all selected quotes.")

api.addWarning("Building chart!")

// Add labels, in the backend referred to as "translations"
labels.each { name, label ->
    matrix.withColumnTranslation(name, ['': label])
}

return matrix

List<Quote> findQuotes() {
    def quoteUtils = libs.Library_Sales.Quotes
    def quotes = quoteUtils.getByYear(year)
    api.trace(api.jsonEncode(quotes))
    return quotes
}

def getStatusCell(ResultMatrix matrix, String quoteStatus) {
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