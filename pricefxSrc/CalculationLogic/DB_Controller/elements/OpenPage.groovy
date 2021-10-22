def controller = api.newController()

controller.addHTML("<h2>Navigates to a page</h2>")
controller.addHTML("<h3>Master Data</h3>")

controller.addButton("Products","productsPage")
controller.addButton("Pricing Parameters","pricingParametersPage")

controller.addHTML("<h3 style='margin-top: 20px;'>Modules</h3>")

controller.addButton("Quotes","priceShopPage")
controller.addButton("Price Lists","priceListPage")

return controller