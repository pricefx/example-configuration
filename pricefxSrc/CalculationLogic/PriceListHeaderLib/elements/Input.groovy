/**
 * In price list header logics, returns the value entered by user into an input field on the pricelist header.
 * @param inputName the name of the input
 * @return the value of the input
 */
def getValue(String inputName){
    // Mock if necessary
    if (api.debugMode) {
        api.trace("""
            Note: The input is mocked by reading from the input binding variable, because the code
             is executed in regular execution mode. However, in production, price list headers are only executed
             in Input Generation mode and the input is accessed differently.
        """)
        return input[inputName]
    }

    // For price list header logics, api.currentItem() is only available in Input Generation mode
    String configurationJson = api.currentItem().configuration
    Map configuration = api.jsonDecode(configurationJson) as Map
    return configuration
            ?.headerInputs
            ?.find { it.name == inputName }
            ?.value
}

/**
 * With this method, you can read the inputs with the [] operators. For example:
 * <pre>
 *     def priceListHeaderInputs = libs.PriceListHeaderLib.Input
 *     def inputValue = priceListHeaderInputs[inputName]
 * <pre>
 * @param inputName
 * @return
 */
def getAt(String inputName) {
    return getValue(inputName)
}
