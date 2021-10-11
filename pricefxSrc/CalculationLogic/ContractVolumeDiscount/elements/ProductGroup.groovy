final String INPUT_NAME = "ProductGroup"

if (api.isSyntaxCheck()) {
    api.inputBuilderFactory().createProductGroupEntry().getInput()
} else {
    return ProductGroup.fromMap(input[INPUT_NAME])
}