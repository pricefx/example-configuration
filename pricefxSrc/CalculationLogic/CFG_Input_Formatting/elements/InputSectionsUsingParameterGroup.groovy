//api.logInfo("My Configurator executed")

def input1 =
        api.inputBuilderFactory()
                .createStringUserEntry("myItemInput")
                .setParameterGroup("My Parameter Group 1")

                .setLabel("My Label")

//            .setValue("My precious")
                .setRequired(true)

                .setTitle("My Title - Short explanation of the input value meaning")
              //  .setValueHint("My Value Hint")
                .setHelpText("My Help Text - Very helpful explanation of the input value meaning.")
                .setHelpLink("https://google.com")
                .setPlaceholderText("My Placeholder Text - Write your magic here")


        //.setReadOnly(true)
//            .setNoRefresh(true)    //makes sense only when the input is in Configurator form
        //.setAutoFocus(true)

        .setConfigValues()
//            .setFlex(2)

                .buildContextParameter()


def input2 = api.inputBuilderFactory()
        .createStringUserEntry("myHeaderInput2")
        .setParameterGroup("My Parameter Group 2")
        .buildContextParameter()

def input3 = api.inputBuilderFactory()
        .createStringUserEntry("myHeaderInput3")
        .setParameterGroup("My Parameter Group 2")
        .buildContextParameter()


// define a Section
def formFieldSet = api.createConfiguratorEntry()
formFieldSet.inputs = [input1, input2, input3]

return formFieldSet
