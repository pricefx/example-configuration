import net.pricefx.common.api.InputType

// the Extra Surcharge section will display only if the Delivery Type "Extra" is selected
if (input.DeliveryType == "Extra") {
    def section = api.createConfiguratorEntry()
    def deliveryTypeInput = section.createParameter(InputType.USERENTRY, "ExtraSurcharge")

    // Reporting of problems (either technical or business)
    if (deliveryTypeInput.getValue() < 3) {
        section.setMessage("<div style='color:red;'>" +
                "error message: Extra Surcharge must be at least 3" +
                "</div>"
        )
    }

    return section
}