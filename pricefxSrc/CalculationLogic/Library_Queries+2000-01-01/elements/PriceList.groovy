/**
 * @param priceListFilter
 * @param callback a closure with two arguments: priceList and priceListItem.
 */
void forEachPriceListItem(Filter priceListFilter, Closure callback){
    // The price list item type does not store the target date for the price list
    api.stream("PL", null, priceListFilter).each { priceList ->
        def targetDate = priceList.targetDate
        def priceListId = priceList.id
        def filter = Filter.equal('pricelistId', priceListId)
        api.stream("PLI", null, filter).each { pricelistItem ->
            callback(priceList, pricelistItem)
        }.close()
    }.close()
}