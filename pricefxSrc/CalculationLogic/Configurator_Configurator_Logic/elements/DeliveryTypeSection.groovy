import net.pricefx.common.api.InputType

api.trace("input", input)

// the DeliveryType section will display only if the ShipTo is already selected
if (input.ShipTo) {

    def section = api.createConfiguratorEntry()
    def deliveryTypeInput = section.createParameter(InputType.OPTION, "DeliveryType")
            .setValueOptions(
                    api.namedEntities(
                            api.findLookupTableValues(
                                    "FreightSurcharge",
                                    Filter.equal("Country", input.ShipTo)
                            )
                    )?.collect { it.DeliveryType }?.sort()
            )

    return section
}

