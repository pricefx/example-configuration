final String INPUT_NAME = "CustomerGroup"

if (api.isSyntaxCheck()) {
    api.inputBuilderFactory().createCustomerGroupEntry().getInput()
} else {
    return CustomerGroup.fromMap(input[INPUT_NAME])
}