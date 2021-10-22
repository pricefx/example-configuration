/**
 *
 * @param moneyAmount How much money to convert
 * @param fromCurrency In which currency is the provided moneyAmount
 * @param toCurrency In which currency would you like the result
 * @return Amount of Money in the toCurrency, or null, if error occurred
 */
BigDecimal convertMoney(BigDecimal moneyAmount, String fromCurrency, String toCurrency) {
    BigDecimal exchangeRate = 1.0
    BigDecimal resultAmount = null

    if (fromCurrency != toCurrency) {
        def conversionDateAsString = api.targetDate()?.format("yyyy-MM-dd")
        exchangeRate = api.findLookupTableValues("ExchangeRate",
                Filter.equal("FromCurrency", fromCurrency),
                Filter.equal("ToCurrency", toCurrency),
                Filter.lessOrEqual("ValidFrom", conversionDateAsString),
                Filter.greaterOrEqual("ValidTo", conversionDateAsString)
        )?.find()?.attribute2
    }

    if (exchangeRate != null && moneyAmount != null) {
        resultAmount = moneyAmount * exchangeRate
    } else {
        api.addWarning("Cannot convert money because either exchange rate or money amount is empty")
    }

    return resultAmount

}