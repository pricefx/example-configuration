import groovy.transform.Field

@Field final String TABLE_NAME_EXCHANGE_RATES = 'ExchangeRatePerMonth'

/**
 * This method converts money between two currencies.
 *
 * The exchange rate is specified in the Price Parameter "CurrencyConversion"
 * and varies over time. An exchange rate is valid for only one month. The
 * method uses the month of the <code>date</code> parameter to find the exchange rates.
 *
 * Since there is only a mapping between EUR and other currencies, the method
 * may have to do an intermediary conversion:
 *
 * currencyFrom -> EUR -> currencyTo
 *
 * The method returns null if any of the arguments is null, or if the currency
 * conversion fails in any other regard.
 *
 * @param amount the amount of money that is to be converted into another currency
 * @param currencyFrom the currency the money is to be converted from
 * @param currencyTo the currency the money is to be converted from
 * @return the amount of money in the currency <code>currencyTo</code>, or
 * <code>null</code> if the conversion failed.
 *
 */
BigDecimal convertCurrency(
        BigDecimal amount,
        String currencyFrom,
        String currencyTo,
        Date date = libs.TrainingLib.DateUtils.today()
) {

    if (amount == null || currencyFrom == null || currencyTo == null || date == null) {
        return null
    }

    if (currencyFrom == currencyTo) {
        // Exchange rate = 1
        return amount
    }

    String month = date.format("yyyy-MM")

    def rateFrom = api.vLookup(TABLE_NAME_EXCHANGE_RATES, "InEuros", currencyFrom, month)
    def rateTo = api.vLookup(TABLE_NAME_EXCHANGE_RATES, "InEuros", currencyTo, month)

    if (!rateFrom || !rateTo) {
        return null
    }

    def amountInEuros = amount * rateFrom
    def amountInToCurrency = amountInEuros / rateTo

    return amountInToCurrency
}