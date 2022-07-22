if (customFormProcessor.isPrePhase()) {
    api.logInfo("CustomForm", "----------------------------")
    api.logInfo("CustomForm", "PRE-phase")

    api.logInfo("CustomForm", "Create Input Fields")

    final String INPUT_FIELD_NAME = "MyInputField"

    Map inputFieldDefinition = api.inputBuilderFactory()
            .createUserEntry(INPUT_FIELD_NAME)
            .setLabel("My Input Field")
            .buildMap()

    customFormProcessor.addOrUpdateInput(inputFieldDefinition)

}

