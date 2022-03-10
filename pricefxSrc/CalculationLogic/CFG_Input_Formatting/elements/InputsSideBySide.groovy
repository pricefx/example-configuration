def inputRow = api.inputBuilderFactory()
        .createRowLayout("MyRowLayout1")

        .addInput(
                api.inputBuilderFactory()
                        .createUserEntry("UserEntry1")
                        .setFlex(1)
                        .buildContextParameter()
        )

        .addInput(
                api.inputBuilderFactory()
                        .createTextUserEntry("TextUserEntry1")
                        .setFlex(2)
                        .buildContextParameter()
        )

        .addInput(
                api.inputBuilderFactory()
                        .createStringUserEntry("StringUserEntry1")
                        .buildContextParameter()
        )

        .buildContextParameter()

// define a Section
def formFieldSet = api.createConfiguratorEntry()
formFieldSet.inputs = [inputRow]

return formFieldSet
