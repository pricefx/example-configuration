final String DEFAULT_INPUT_NAME_PRODUCT_GROUP = "ProductGroup"

if (api.isSyntaxCheck()) {
    api.inputBuilderFactory().createProductGroupEntry(DEFAULT_INPUT_NAME_PRODUCT_GROUP)
            .getInput()
} else {
    return ProductGroup.fromMap(input[DEFAULT_INPUT_NAME_PRODUCT_GROUP])
}
