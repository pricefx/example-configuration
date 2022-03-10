if (quoteProcessor.isPrePhase()) {

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

            .buildMap()


    quoteProcessor.addOrUpdateInput(inputRow)
}