api.trace(quote)

return quote.inputs?.find { it.name = "Customer" }?.value