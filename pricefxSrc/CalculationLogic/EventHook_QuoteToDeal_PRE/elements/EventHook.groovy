//api.logInfo("QUOTE_TO_DEAL_PRE Logic", "============================")
//api.logInfo("quote", api.jsonEncode(quote))
//def quoteWithItems = api.getCalculableLineItemCollection(quote.typedId)
//api.logInfo("quoteWithItems", api.jsonEncode(quoteWithItems))
//api.logInfo("api.currentContext()", api.currentContext())

if ("CD-00008" == quote.customerId) {
//    api.logInfo("result", "Quote with customer CD-00008 is not allowed to convert to Deal.")
    api.setAlertMessage("Quote with customer CD-00008 is not allowed to convert to Deal." +
            " This is blocked by Event Hook logic.")
    return false
}

//api.logInfo("result", "Quote can be converted to Deal.")
return true