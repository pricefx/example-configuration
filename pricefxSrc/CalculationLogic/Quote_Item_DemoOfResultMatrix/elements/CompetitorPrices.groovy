//added to STUB

import net.pricefx.common.api.FieldFormatType

// Library
def competitorUtils = libs.TrainingLib.CompetitorUtils

if (out.Currency == null) {
    api.addWarning('A Customer must be selected for the quote')
    return
}

String sku = api.product('ProductId')
List<Map<String, BigDecimal>> competitorPricesByCountry = competitorUtils.getCompetitorPricesByCountry(sku, out.Currency)

api.trace(competitorPricesByCountry) //TODO comment out in production code

// Define the column names (visible to the end-user)
final String COLUMN_NAME_COUNTRY = "Country"
final String COLUMN_NAME_MIN_PRICE = "Minimum Price (${out.Currency})"
final String COLUMN_NAME_AVG_PRICE = "Average Price (${out.Currency})"
final String COLUMN_NAME_MAX_PRICE = "Maximum Price (${out.Currency})"

// Create an empty ResultMatrix
def resultMatrix = api.newMatrix(
        COLUMN_NAME_COUNTRY,
        COLUMN_NAME_MIN_PRICE,
        COLUMN_NAME_AVG_PRICE,
        COLUMN_NAME_MAX_PRICE,
)

// Set Formatting
resultMatrix.setColumnFormat(COLUMN_NAME_COUNTRY, FieldFormatType.TEXT)
resultMatrix.setColumnFormat(COLUMN_NAME_MIN_PRICE, FieldFormatType.MONEY)
resultMatrix.setColumnFormat(COLUMN_NAME_AVG_PRICE, FieldFormatType.MONEY)
resultMatrix.setColumnFormat(COLUMN_NAME_MAX_PRICE, FieldFormatType.MONEY)

competitorPricesByCountry.each { competitorPriceInfo ->
    String GREEN = "#88CC00"
    String RED = "#FF4400"
    def averagePriceCell = resultMatrix.styledCell(
            competitorPriceInfo.averagePrice,
            'white',
            out.InvoicePrice < competitorPriceInfo.averagePrice ? GREEN : RED,
            'bold'
    )

    resultMatrix.addRow([
            (COLUMN_NAME_COUNTRY)  : competitorPriceInfo.country,
            (COLUMN_NAME_MIN_PRICE): competitorPriceInfo.minPrice,
            (COLUMN_NAME_AVG_PRICE): averagePriceCell,
            (COLUMN_NAME_MAX_PRICE): competitorPriceInfo.maxPrice,
    ])
}

return resultMatrix