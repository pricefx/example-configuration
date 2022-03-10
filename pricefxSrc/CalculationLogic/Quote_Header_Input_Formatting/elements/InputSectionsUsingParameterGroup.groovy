if (quoteProcessor.isPrePhase()) {


    def input1 = api.inputBuilderFactory()
            .createStringUserEntry("myHeaderInput1")
            .setParameterGroup("My Parameter Group 1")

            .setLabel("My Label")

//            .setValue("My precious")
            .setPlaceholderText("My Placeholder Text - Write your magic here")
            .setRequired(true)

            .setTitle("My Title - Short explanation of the input value meaning")
            .setValueHint("My Value Hint")
            .setHelpText("My Help Text - Very helpful explanation of the input value meaning.")
            .setHelpLink("https://google.com?q=my precious")

            .buildMap()


    def input2 = api.inputBuilderFactory()
            .createStringUserEntry("myHeaderInput2")
            .setParameterGroup("My Parameter Group 2")
            .buildMap()
    def input3 = api.inputBuilderFactory()
            .createStringUserEntry("myHeaderInput3")
            .setParameterGroup("My Parameter Group 2")

            .buildMap()

    quoteProcessor.addOrUpdateInput(input1)
    quoteProcessor.addOrUpdateInput(input2)
    quoteProcessor.addOrUpdateInput(input3)

}