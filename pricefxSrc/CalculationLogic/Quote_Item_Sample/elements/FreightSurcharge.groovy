if(api.isDebugMode()) {
    input.Customer = "CD-00004"      // Pricefx
    input.DeliveryType = "Standard"
}

def country = api.customer("Country", input.Customer)

def keys = [
        "Country": country,
        "DeliveryType": input.DeliveryType
]

return api.vLookup("FreightSurcharge", "FreightSurcharge", keys)