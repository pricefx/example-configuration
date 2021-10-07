def costEUR = api.productExtension("ProductCost")?.find()?.attribute1
return libs.MoneyUtils.ExchangeRate.convertMoney(costEUR, "EUR", out.Currency)
