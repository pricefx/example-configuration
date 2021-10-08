def sku = input[Const.PRODUCT_INPUT_NAME]

def inputField = api.inputBuilderFactory().createProductEntry(Const.PRODUCT_INPUT_NAME)
        .setRequired(true)
        .setLabel("Please select Product")
        .setValue(sku)    // if you do not set the value of the input, it will always appear empty after each refresh of the Configurator Form.
        .buildContextParameter()

def formSection = api.createConfiguratorEntry()
formSection.addParameter(inputField)

return formSection
