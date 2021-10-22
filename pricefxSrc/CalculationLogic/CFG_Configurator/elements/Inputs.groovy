//Process the possible combinations of the input values

def shipTo = input[Const.INPUT_NAME_SHIP_TO]
def deliveryType = input[Const.INPUT_NAME_DELIVERY_TYPE]
def extraSurcharge = input[Const.INPUT_NAME_EXTRA_SURCHARGE]

if (shipTo) {
    //ShipTo is set, the Delivery Type could be only of certain type

    if (!(deliveryType in out.DeliveryTypes)) {
        //if Delivery Type is set to non-allowed value, reset it
        deliveryType = null
    }

    if (deliveryType != "Extra") {
        //when delivery type is not "extra", then the last value should be always empty
        extraSurcharge = null
    }
} else {
    //ShipTo is set to "nothing", let's reset all other values
    deliveryType = null
    extraSurcharge = null
}

return [
        shipTo        : shipTo,
        deliveryType  : deliveryType,
        extraSurcharge: extraSurcharge
]
