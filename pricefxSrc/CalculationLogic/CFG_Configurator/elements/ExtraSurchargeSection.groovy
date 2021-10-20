// the Extra Surcharge section will display only if the Delivery Type "Extra" is selected
if (out.Inputs.deliveryType == "Extra") {
    def formSection = api.createConfiguratorEntry()

    def deliveryTypeInputField = api.inputBuilderFactory().createUserEntry(Const.INPUT_NAME_EXTRA_SURCHARGE)
            .setValue(out.Inputs.extraSurcharge)
            .buildContextParameter()

    formSection.setInputs([deliveryTypeInputField])

    // Reporting of problems (either technical or business)
    if (deliveryTypeInputField.getValue() < 3) {
        formSection.setMessage("<div style='color:red;'>" +
                "Error: Extra Surcharge must be at least 3" +
                "</div>"
        )
    }

    return formSection
}