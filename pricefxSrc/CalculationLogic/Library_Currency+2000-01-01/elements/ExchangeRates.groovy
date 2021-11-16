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

    if (null in [amount, currencyFrom, currencyTo, date]) {
        throw new Exception("All arguments must must be non-null")
    }

    if (currencyFrom == currencyTo) {
        // Exchange rate = 1
        return amount
    }

    String month = date.format("yyyy-MM")

    def rateFromKeys = [
            key1: currencyFrom,
            key2: month
    ]

    def rateToKeys = [
            key1: currencyTo,
            key2: month
    ]

    def rateFrom = api.vLookup(
            TABLE_NAME_EXCHANGE_RATES,
            ['InEuros'],
            rateFromKeys
    )?.getAt('InEuros') as BigDecimal
    if (rateFrom == null) {
        throw new Exception("Failed to find rateFrom with keys ${rateFromKeys}")
    }

    def rateTo = api.vLookup(
            TABLE_NAME_EXCHANGE_RATES,
            ["InEuros"],
            rateToKeys
    )?.getAt('InEuros') as BigDecimal
    if (rateTo == null) {
        throw new Exception("Failed to find rateTo with keys ${rateToKeys}")
    }
    if(rateTo == 0){
        throw new Exception("rateTo is 0, which would lead to division by zero.")
    }

    def amountInEuros = amount * rateFrom
    def amountInToCurrency = amountInEuros / rateTo

    return amountInToCurrency
}