if (api.isInputGenerationExecution()) {

    api.inputBuilderFactory()
            .createStringUserEntry("myItemInput")
            .setParameterGroup("My Parameter Group 1")

            .setLabel("My Label")

//            .setValue("My precious")
            .setPlaceholderText("My Placeholder Text - Write your magic here")
            .setRequired(true)

            .setTitle("My Title - Short explanation of the input value meaning")
            .setValueHint("My Value Hint")
            .setHelpText("My Help Text - Very helpful explanation of the input value meaning.")
            .setHelpLink("https://google.com")


    //.setReadOnly(true)
//            .setNoRefresh(true)    //makes sense only when the input is in Configurator form
    //.setAutoFocus(true)

//        .setConfigValues()
//            .setFlex(2)

            .getInput()


    api.inputBuilderFactory()
            .createStringUserEntry("myHeaderInput2")
            .setParameterGroup("My Parameter Group 2")
            .getInput()
    api.inputBuilderFactory()
            .createStringUserEntry("myHeaderInput3")
            .setParameterGroup("My Parameter Group 2")
            .getInput()

}
