def getValue(String inputName){
    if (api.debugMode) {
        api.trace("""
            Note: The input is mocked by reading from the input binding variable, because the code
             is executed in regular execution mode. However, in production, price list headers are only executed
             in syntax check mode and the input is accessed differently.
        """)
        return input[inputName]
    }
    // For price list header logics, api.currentItem() is only available in syntax check mode
    String configurationJson = api.currentItem().configuration
    Map configuration = api.jsonDecode(configurationJson) as Map
    return configuration
            ?.headerInputs
            ?.find { it.name == inputName }
            ?.value
}

def getAt(String inputName) {
    return getValue(inputName)
}
