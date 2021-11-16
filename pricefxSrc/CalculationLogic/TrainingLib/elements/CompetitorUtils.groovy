import net.pricefx.domain.ProductCompetition

/**
 * Calculates the average competitor prices for given SKU and date-range, and provides the aggregation per Country.
 * @param sku For which SKU you want the competitior prices
 * @param dateFrom First day of the date range
 * @param dateTo Last date of the date range
 * @param currency In which currency you need the result.
 * @return List of objects with information about the competitor prices. It's a List of Maps in format [country:"Germany", averagePrice:10.1, maxPrice:15.3, minPrice:8.2]
 */
List<Map<String, ?>> getCompetitorPricesByCountry(
        String sku,
        String currency,
        Date dateFrom = libs.TrainingLib.DateUtils.oneYearAgo(),
        Date dateTo = new Date()
) {
    def exchangeRates = libs.Library_Currency.ExchangeRates
    def dateUtils = libs.TrainingLib.DateUtils

    Map<String, Map<String, BigDecimal>> competitorPriceInfoByCountry = [:]
    Iterator<ProductCompetition> iterator = api.stream('PCOMP', null,
            Filter.equal('sku', sku),
            Filter.greaterOrEqual('infoDate', dateUtils.formatDate(dateFrom)),
            Filter.lessOrEqual('infoDate', dateUtils.formatDate(dateTo))
    )
    for (row in iterator) {
        Map<String, BigDecimal> competitorPriceInfo = competitorPriceInfoByCountry[row.country]
        BigDecimal price = exchangeRates.convertCurrency(row.price as BigDecimal, row.currency, currency)
        competitorPriceInfoByCountry[row.country] = [
                priceCount      : competitorPriceInfo ? competitorPriceInfo.priceCount + 1 : 1,
                accumulatedPrice: competitorPriceInfo ? competitorPriceInfo.accumulatedPrice + price : price,
                minPrice        : competitorPriceInfo ? Math.min(competitorPriceInfo.minPrice, price) : price,
                maxPrice        : competitorPriceInfo ? Math.max(competitorPriceInfo.maxPrice, price) : price,
        ]
    }
    List<Map<String, ?>> competitorPriceByCountry = competitorPriceInfoByCountry.collect { country, accumulation ->
        [
                country     : country,
                averagePrice: accumulation.accumulatedPrice / accumulation.priceCount,
                maxPrice    : accumulation.maxPrice,
                minPrice    : accumulation.minPrice,
        ]
    }
    return competitorPriceByCountry
}