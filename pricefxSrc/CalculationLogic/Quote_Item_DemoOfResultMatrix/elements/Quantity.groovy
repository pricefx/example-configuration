final String INPUT_NAME_QUANTITY = "Quantity"
final String INPUT_LABEL_QUANTITY = "Quantity"

if (api.isInputGenerationExecution()) {
    // Input Generation mode: create input parameter
    api.inputBuilderFactory().createIntegerUserEntry(INPUT_NAME_QUANTITY)
            .setLabel(INPUT_LABEL_QUANTITY)
            .setRequired(true)
            .getInput()
} else {
    // Normal mode: read, validate and return input values
    def quantity = input[INPUT_NAME_QUANTITY]

    // Values greater than Integer.MAX_VALUE will result in a returned String
    if (quantity == null) {
        api.addWarning("$INPUT_LABEL_QUANTITY input is required.")
        return null
    }
    if (quantity < 0) {
        api.addWarning("$INPUT_LABEL_QUANTITY must be greater or equal to 0.")
        return null
    }

    return quantity
}