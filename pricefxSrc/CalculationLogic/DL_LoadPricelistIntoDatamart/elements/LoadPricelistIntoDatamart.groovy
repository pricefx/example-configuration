def pricelistIterator = api.stream("PL", null)
def targetDates = pricelistIterator?.collectEntries { pl -> [(pl.id): (pl.targetDate)] }
pricelistIterator?.close()

def targetRowset = api.getDatamartRowSet("target")

def itemIterator = api.stream("PLI", "sku")
itemIterator?.each { pli ->
    def targetDate = targetDates[pli.pricelistId]
    if (targetDate) {
        def row = [ProductId: pli.sku, TargetDate: targetDate, ResultPrice: pli.resultPrice, Currency: pli.currency]
        targetRowset?.addRow(row)
    }
}
itemIterator?.close()

//    pli.targetDate  // is empty
//    pli.unitOfMeasure
//    pli.updateDate  //easier solution but not correct
//    pli.pricelistId
//    pli.listLabel
