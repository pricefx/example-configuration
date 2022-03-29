if (quoteProcessor.isPrePhase()) {

    for (int i = 1; i <= 10; i++) {

        def inputField = api.inputBuilderFactory()
                .createUserEntry("UserEntry$i".toString())
                .buildMap()

        quoteProcessor.addOrUpdateInput(inputField)

    }


}
