final String INPUT_REQUESTED_PRICE = "RequestedPrice"

if (api.isSyntaxCheck()) {
    api.inputBuilderFactory().createUserEntry(INPUT_REQUESTED_PRICE)
            .setLabel("Requested Price")
            .getInput()
} else {
    return input[INPUT_REQUESTED_PRICE]
}
