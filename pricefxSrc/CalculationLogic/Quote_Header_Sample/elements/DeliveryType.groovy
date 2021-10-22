if (quoteProcessor.isPrePhase()) {

    def deliveryTypeInputField = api.inputBuilderFactory()
            .createOptionEntry("DeliveryType")
            .setLabel("Delivery Type")
            .setRequired(true)
            .setOptions(["Express", "Standard"])
            .setLabels(["Express": "Express Delivery", "Standard": "Standard Delivery"])
            .buildMap()

    quoteProcessor.addOrUpdateInput(deliveryTypeInputField)

}