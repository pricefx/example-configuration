def cost = api.currentItem().attribute1

def date = api.targetDate().format("yyyy-MM-dd")

def filters = [
        Filter.equal("key1", "EUR"),  // From Ccy
        Filter.equal("key2", "USD"),    // To Ccy
        Filter.lessOrEqual("key3", date),           // Valid From
        Filter.greaterOrEqual("attribute1", date),  // Valid To
];

def exchangeRate = api.findLookupTableValues("ExchangeRate",
        *filters)?.find()?.attribute2

return (cost != null && exchangeRate != null) ? (cost * exchangeRate) : null