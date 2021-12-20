// Imports
def costs = libs.Library_Product.Cost
def countries = libs.Library_Geography.Country
def regions= libs.Library_Geography.Region
def costPlus= libs.Library_Pricing.CostPlus
def results = libs.Library_Results.Results

// Region
def region = countries.findRegionByCountry(countryCode)
results.add('Region', region)
if(region == null){
    results.addError('Region', "Failed to find the region for country '${countryCode}'")
    return
}

// Currency
def currency = regions.findCurrencyByRegion(region)
results.add('Currency', currency)
if(currency == null){
    results.addError('Currency', "Failed to find the currency for region '${region}'")
    return
}

// Product Cost
def productCost = costs.findCost(sku, currency, api.targetDate())
results.add('ProductCost', productCost)
if(productCost == null){
    results.addError('ProductCost', "Failed to find a product cost entry for sku='${sku}', currency='${currency}', validAfter > ${api.targetDate()}")
    return
}

// Markup
def countryMarkupCoefficient = costPlus.findCountryMarkupCoefficient(countryCode)
results.add('MarkupPct', countryMarkupCoefficient)
if(countryMarkupCoefficient == null){
    // TODO
    results.addError('MarkupPct', "Failed to find a country markup coefficient for countryCode='$countryCode'")
    return
}

// Markup
def markup = productCost * countryMarkupCoefficient
results.add('Markup', markup)

// ListPrice
def listPrice = productCost + markup
results.add('ListPrice', listPrice)

return

/*
 * Utils
 */

String getCountryCode() {
    input.countryCode as String
}

String getSku() {
    api.currentItem('sku')
}