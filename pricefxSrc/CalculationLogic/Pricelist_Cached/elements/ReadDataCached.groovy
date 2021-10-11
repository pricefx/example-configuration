def getAllFreightSurcharges() {
    //original code
    return api.namedEntities(
            api.findLookupTableValues("FreightSurcharge")
    )
}

def getCachedAllFreightSurcharges() {
    final key = "FreightSurchargeDataCacheKey"

    if (api.global.containsKey(key)) {
        return api.global[key]
    }

    def data = getAllFreightSurcharges()

    api.global[key] = data

    return data
}

return getCachedAllFreightSurcharges()