if (quoteProcessor.isPrePhase()) {

    def customerInputField = api.inputBuilderFactory()
            .createCustomerEntry()
            .setRequired(true)
            .buildMap()

    quoteProcessor.addOrUpdateInput(customerInputField)

}
