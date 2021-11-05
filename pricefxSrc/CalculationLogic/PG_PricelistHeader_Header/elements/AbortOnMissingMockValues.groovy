def priceGridId = Lib.getPriceGridId()

if (api.isDebugMode() && !priceGridId) {
    def msg = 'Please provide a mock value for MOCK_PRICE_GRID_ID in Lib.groovy'
    api.criticalAlert(msg)
    api.addWarning(msg)
    api.trace(msg)
    api.abortCalculation()
}
