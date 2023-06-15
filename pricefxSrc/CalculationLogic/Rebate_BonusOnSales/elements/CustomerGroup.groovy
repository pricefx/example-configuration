final String DEFAULT_INPUT_NAME_CUSTOMER_GROUP = "CustomerGroup"

if (api.isInputGenerationExecution()) {
    api.inputBuilderFactory().createCustomerGroupEntry(DEFAULT_INPUT_NAME_CUSTOMER_GROUP)
            .getInput()
} else {
    return CustomerGroup.fromMap(input[DEFAULT_INPUT_NAME_CUSTOMER_GROUP])
}
