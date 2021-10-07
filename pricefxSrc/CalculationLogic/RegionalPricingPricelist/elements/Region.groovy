def regions = api.findLookupTableValues("Region")?.collect { it.name }?.sort()
return api.option("Region", regions)