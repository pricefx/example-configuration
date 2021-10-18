def costEUR = api.productExtension("ProductCost")?.find()?.attribute1
return libs.MoneyLib.ExchangeRateUtils.convertMoney(costEUR, "EUR", out.Currency)