final String INPUT_QUANTITY = "Quantity"

if (api.isInputGenerationExecution()) {
    api.inputBuilderFactory().createUserEntry(INPUT_QUANTITY)
            .setRequired(true)
            .getInput()
} else {
    return input[INPUT_QUANTITY]
}
