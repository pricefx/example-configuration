def sku = input[Const.PRODUCT_INPUT_NAME]


if (sku) {
    //one of Acceptance Criteria requires us to show the current and future description only after the Product is selected.
    def description = api.product("label", sku)

    def inputField = api.inputBuilderFactory()
            .createStringUserEntry(Const.DESCRIPTION_INPUT_NAME)
            .setRequired(true)
            .setLabel("Set new Product Description")
            .setValue(description)
            .setNoRefresh(true) //avoid reload of the Configurator when the user changes the value of this input
            .buildContextParameter()


    def formSection = api.createConfiguratorEntry()
    formSection.addParameter(inputField)
    formSection.setMessage("<div style='font-size:12px; color:#555555'>" +
                            "Original Label: ${description}</div>")
    return formSection
}



