// define a Section
def formFieldSet = api.createConfiguratorEntry()

// add one dropdown input field
def shipToInputField = api.inputBuilderFactory().createOptionEntry(Const.INPUT_NAME_SHIP_TO)
        .setOptions(out.Countries)
        .setValue(out.Inputs.shipTo)
        .buildContextParameter()

formFieldSet.inputs = [shipToInputField]

//return the Section definition. The logic Element containing this code must have DisplayMode set to Everywhere
return formFieldSet