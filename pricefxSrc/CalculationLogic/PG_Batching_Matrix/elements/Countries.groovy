if (api.global.countryCodeList==null) {
    api.global.countryCodeList = api.findLookupTableValues("CountryAdjustment", null, ["name"], "name")?.name
}

return api.global.countryCodeList



