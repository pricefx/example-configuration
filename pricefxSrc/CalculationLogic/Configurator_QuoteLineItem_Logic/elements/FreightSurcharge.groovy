//added to STUB

//read values returned from Configurator form
def shipTo = input[Constants.CONFIGURATOR_INPUT_NAME]?.ShipTo
def deliveryType = input[Constants.CONFIGURATOR_INPUT_NAME]?.DeliveryType
def extraSurcharge = input[Constants.CONFIGURATOR_INPUT_NAME]?.ExtraSurcharge

if (shipTo && deliveryType) {

    if (deliveryType == "Extra") {
        return extraSurcharge
    } else {

        def freightSurcharge = api.vLookup("FreightSurcharge", "FreightSurcharge", shipTo, deliveryType)
        if (freightSurcharge != null) {
            return freightSurcharge
        } else {
            api.addWarning("Freight surcharge was not found for ShipTo: $shipTo and DeliveryType: $deliveryType")
        }

    }

} else {
    api.addWarning("Cannot calculate Freight Surcharge, because ShipTo or DeliveryType was not specified.")
}