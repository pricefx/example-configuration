def controller = api.newController()


controller.addHTML("<h2>Navigates to specific destination</h2>")
controller.addHTML("<h3>Specific Data Tables</h3>")



def ppTableName = api.find("LT", 0, 1, "uniqueName")?.uniqueName?.getAt(0)
controller.addButton("Open PriceParameter '${ppTableName}'", "pricingParametersPage", api.findLookupTable(ppTableName)?.typedId)


controller.addHTML("<h3 style='margin-top: 20px;'>Specific Documents</h3>")


def pricelist = api.find("PL", 0, 1, "label")?.getAt(0)
controller.addButton("Open Pricelist '${pricelist?.label}'", "priceListPage", pricelist?.id)

def quote = api.find("Q", 0, 1, "uniqueName")?.getAt(0)
controller.addButton("Open Quote '${quote?.uniqueName}'", "priceShopPage", quote?.uniqueName)


controller.addHTML("<h3 style='margin-top: 20px;'>Specific Dashboard or Wizard</h3>")


def dashboard = api.find("DB", Filter.isNull("hide"))?.getAt(0)
controller.addButton("Open Dashboard '${dashboard?.uniqueName}'", "dashboardPage", null, dashboard?.uniqueName)

def configurationWizard = api.find("CW", 0, 1, "uniqueName")?.getAt(0)
controller.addButton("Open Configuration Wizards '${configurationWizard?.uniqueName}'", "configWizardPage", configurationWizard?.typedId)


return controller