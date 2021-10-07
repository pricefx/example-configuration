def countryAdjPct = api.vLookup("CountryAdjustment", "MarkupAdjustment", out.CountryCode)

if (countryAdjPct == null) {
    api.addWarning("Unable to find Country Adjustment for the Country Code '${out.CountryCode}'")
}

return countryAdjPct