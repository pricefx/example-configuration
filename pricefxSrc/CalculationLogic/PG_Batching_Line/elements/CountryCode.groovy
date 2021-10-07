if (!api.isDebugMode()) {
    return api.getSecondaryKey()
} else {
    if (api.isSyntaxCheck()) {
        api.option("CountryCode", api.findLookupTableValues("CountryAdjustment", null, ["name"], "name")?.name)
    } else {
        return input.CountryCode
    }
}