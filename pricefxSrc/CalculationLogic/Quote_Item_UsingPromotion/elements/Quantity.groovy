final String INPUT_NAME = "Quantity"
if (api.isSyntaxCheck()) {

    api.inputBuilderFactory().createUserEntry(INPUT_NAME).getInput()
} else {
    return input[INPUT_NAME]
}
