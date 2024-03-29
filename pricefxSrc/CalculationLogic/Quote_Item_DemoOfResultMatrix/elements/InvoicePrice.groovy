final String INPUT_NAME_INVOICE_PRICE = "InvoicePrice"
final String INPUT_LABEL_INVOICE_PRICE = "Invoice Price"

if (api.isInputGenerationExecution()) {
    // Input Generation mode: create input parameter
    api.inputBuilderFactory().createUserEntry(INPUT_NAME_INVOICE_PRICE)
            .setLabel(INPUT_LABEL_INVOICE_PRICE)
            .setRequired(true)
            .getInput()
} else {
    // Normal mode: read, validate and return input values
    def invoicePrice = input[INPUT_NAME_INVOICE_PRICE]

    // Values greater than Integer.MAX_VALUE will result in a returned String
    if (invoicePrice == null) {
        api.addWarning("$INPUT_LABEL_INVOICE_PRICE input is required.")
        return null
    }
    if (invoicePrice < 0) {
        api.addWarning("$INPUT_LABEL_INVOICE_PRICE must be greater or equal to 0.")
        return null
    }

    return invoicePrice
}