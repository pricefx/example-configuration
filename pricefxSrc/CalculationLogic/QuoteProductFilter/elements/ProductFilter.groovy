if (quote.quoteType == "QuoteProductFilter_QuoteType") {
    api.logInfo("QuoteProductFilter used.")

    def businessUnit = quote.inputs?.find { it.name == "BusinessUnit" }?.value

    return Filter.equal("attribute2", businessUnit)
}