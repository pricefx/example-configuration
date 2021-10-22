final String DEFAULT_INPUT_NAME_CUSTOMER_GROUP = "CustomerGroup"
final String DEFAULT_INPUT_NAME_PRODUCT_GROUP = "ProductGroup"

if (cProcessor.isPrePhase()) {
    cProcessor.setRenderInfo("userGroupEdit", "hide", true)
    cProcessor.setRenderInfo("contractExternalRef", 'hide', true)

    def customerGroupInputField = api.inputBuilderFactory()
            .createHiddenEntry(DEFAULT_INPUT_NAME_CUSTOMER_GROUP)
            .buildMap()

    def productGroupInputField = api.inputBuilderFactory()
            .createHiddenEntry(DEFAULT_INPUT_NAME_PRODUCT_GROUP)
            .buildMap()

    cProcessor.addOrUpdateInput(customerGroupInputField)
    cProcessor.addOrUpdateInput(productGroupInputField)
}

