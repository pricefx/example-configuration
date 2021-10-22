Map getCurrentItem() {
    if (api.debugMode) {
        throw new Exception("You're trying to access currentItem in regular execution mode, but price list header logics are only executed in syntax check mode in the UI. The currentItem is only set in syntax check mode.")
    }
    return api.currentItem()
}

def getAt(String inputName) {
    if (api.debugMode) {
        api.trace("""Warning', 'The input is mocked by reading from the input binding variable,
 because the code is executed in regular execution mode. 
 But in production, price list headers are executed in syntax check mode.""")
        return input[inputName]
    }
    // If executing in dev mode, try to mock the current Item by using the CurrentItem element
    String configurationJson = getCurrentItem().configuration
    Map configuration = api.jsonDecode(configurationJson) as Map
    return configuration
            ?.headerInputs
            ?.find { it.name == inputName }
            ?.value
}
