if (quoteProcessor.isPrePhase()) {

    def rowIterator = api.stream("P", "sku", ["attribute2"])
    def businessUnits = rowIterator.collect { it["attribute2"] }?.unique().sort()
    rowIterator.close()

    def businessUnitInputField = api.inputBuilderFactory()
            .createOptionEntry("BusinessUnit")
            .setOptions(businessUnits)
            .buildMap()

    quoteProcessor.addOrUpdateInput(businessUnitInputField)

}