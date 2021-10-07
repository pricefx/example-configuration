def rowIterator = api.stream("P", "sku", ["attribute2"])
def businessUnits = rowIterator.collect {it["attribute2"]}?.unique().sort()
rowIterator.close()

api.trace(businessUnits)
api.inputBuilderFactory().createOptionEntry("BusinessUnit")
        .setOptions(businessUnits)
        .addOrUpdateInput(quoteProcessor, "ROOT")



