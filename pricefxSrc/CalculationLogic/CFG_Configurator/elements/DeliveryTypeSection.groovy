// the DeliveryType section will display only if the ShipTo is already selected
if (out.Inputs.shipTo) {

    def formFieldSet = api.createConfiguratorEntry()

    def deliveryTypeInputField = api.inputBuilderFactory().createOptionEntry(Const.INPUT_NAME_DELIVERY_TYPE)
            .setOptions(out.DeliveryTypes)
            .setValue(out.Inputs.deliveryType)
            .buildContextParameter()

    formFieldSet.inputs = [deliveryTypeInputField]

    return formFieldSet
}

