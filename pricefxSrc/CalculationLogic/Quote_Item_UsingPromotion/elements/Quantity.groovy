final String INPUT_NAME = "Quantity"
if (api.isInputGenerationExecution()) {

    api.inputBuilderFactory().createUserEntry(INPUT_NAME).getInput()
} else {
    return input[INPUT_NAME]
}
