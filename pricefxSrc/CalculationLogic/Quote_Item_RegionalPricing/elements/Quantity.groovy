final String INPUT_QUANTITY = "Quantity"

if (api.isSyntaxCheck()) {
    api.inputBuilderFactory().createUserEntry(INPUT_QUANTITY)
            .setRequired(true)
            .getInput()
} else {
    return input[INPUT_QUANTITY]
}
