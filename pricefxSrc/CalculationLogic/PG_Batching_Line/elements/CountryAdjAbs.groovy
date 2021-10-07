if (out.BasePrice == null
        || out.CountryAdjPct == null) {
    api.addWarning("Country Adjustment cannot be calculated: missing parameter(s)")
    return null
}

return out.BasePrice * out.CountryAdjPct   // it's a markup