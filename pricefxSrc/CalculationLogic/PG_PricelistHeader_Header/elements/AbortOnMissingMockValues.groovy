def priceGridId = Lib.getPriceGridId()

if (!priceGridId) {
    api.trace('Please provide a mock value for MOCK_PRICE_GRID_ID in Lib.groovy')
    api.abortSyntaxCheck()
    return
}
