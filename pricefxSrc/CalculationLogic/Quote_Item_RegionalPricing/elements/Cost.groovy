def costEUR = api.productExtension("ProductCost")?.getAt(0)?.attribute1
return libs.MoneyLib.ExchangeRateUtils.convertMoney(costEUR, "EUR", out.Currency)