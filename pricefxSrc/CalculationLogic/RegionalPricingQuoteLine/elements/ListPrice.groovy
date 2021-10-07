if (out.Region == null) {
    api.addWarning("Cannot find a ListPrice because Region is not available.")
    return null
}

def pliResultPrice = api.pricelist(out.Region)
def pliCurrency = api.vLookup("Region", "Currency", out.Region)    // api.pricelist(region, "Currency")

api.trace("pliResultPrice", pliCurrency, pliResultPrice)

return libs.MoneyUtils.ExchangeRate.convertMoney(pliResultPrice, pliCurrency, out.Currency)