final String INPUT_NAME_QUANTITY = "Quantity"
final String INPUT_LABEL_QUANTITY = "Quantity"

if (api.syntaxCheck) {
    // Syntax check mode: create input parameter
    api.integerUserEntry(INPUT_NAME_QUANTITY)
    def param = api.getParameter(INPUT_NAME_QUANTITY)
    param.setLabel(INPUT_LABEL_QUANTITY)
    param.setRequired(true)
} else {
    // Non-syntax check mode: read, validate and return input values
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