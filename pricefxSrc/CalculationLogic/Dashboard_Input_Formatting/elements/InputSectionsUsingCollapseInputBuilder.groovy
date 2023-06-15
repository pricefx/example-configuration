if (api.isInputGenerationExecution()) {

    api.inputBuilderFactory()
            .createCollapseLayout("MySection1")
            .setLabel(" My Section 1")

            .addInput(
                    api.inputBuilderFactory()
                            .createStringUserEntry("StringUserEntry1")
                            .buildContextParameter()
            )

            .addInput(
                    api.inputBuilderFactory()
                            .createTextUserEntry("TextUserEntry2")
                            .buildContextParameter()
            )

            .getInput()

}