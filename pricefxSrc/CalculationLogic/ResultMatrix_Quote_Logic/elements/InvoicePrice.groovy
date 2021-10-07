final String INPUT_NAME_INVOICE_PRICE = "InvoicePrice"
final String INPUT_LABEL_INVOICE_PRICE = "Invoice Price"

if (api.isSyntaxCheck()) {
    // Syntax check mode: create input parameter
    api.decimalUserEntry(INPUT_NAME_INVOICE_PRICE)
    def param = api.getParameter(INPUT_NAME_INVOICE_PRICE)
    param.setLabel(INPUT_LABEL_INVOICE_PRICE)
    param.setRequired(true)
} else {
    // Non-syntax check mode: read, validate and return input values
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