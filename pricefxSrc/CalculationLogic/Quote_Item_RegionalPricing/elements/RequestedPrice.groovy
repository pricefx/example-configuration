final String INPUT_REQUESTED_PRICE = "RequestedPrice"

if (api.isInputGenerationExecution()) {
    api.inputBuilderFactory().createUserEntry(INPUT_REQUESTED_PRICE)
            .setLabel("Requested Price")
            .getInput()
} else {
    return input[INPUT_REQUESTED_PRICE]
}
