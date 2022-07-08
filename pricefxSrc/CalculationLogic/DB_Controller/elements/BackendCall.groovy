def controller = api.newController()

controller.addHTML("<h2>Start a background process</h2>")


controller.addHTML("<h3>Recalculate Price List/Grid</h3>")

def pricelist = api.find("PL", 0, 1, null)?.getAt(0)
if (pricelist) {
    controller.addBackendCall("Calculate Pricelist '${pricelist?.label}'",
            "/pricelistmanager.calculate/${pricelist?.id}",
            null,
            "Request issued", "Request failed")
} else {
    controller.addHTML("<em>No Pricelist found on the partition</em>")
}

def lpg = api.find("PG", 0, 1, null)?.getAt(0)
if (lpg) {
    controller.addBackendCall("Calculate Live Price Grig '${lpg?.label}'",
            "/pricegridmanager.calculate/${lpg?.id}",
            null,
            "Request issued", "Request failed")
} else {
    controller.addHTML("<em>No LivePriceGrid found on the partition</em>")
}


controller.addHTML("<h3 style='margin-top: 20px;'>Run Calculation Flow</h3>")

def cf = api.find("CF", Filter.equal("draft", false))?.getAt(0)
if (cf) {
    controller.addBackendCall("Start Calculation Flow '${cf?.uniqueName}'",
            "/add/CFT",
            PayloadLib.calculationFlowTraitPayload(cf?.uniqueName),
            "Request issued", "Request failed")
} else {
    controller.addHTML("<em>No deployed Calculation Flow found on the partition</em>")
}


return controller