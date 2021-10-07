//TODO remove this ELEMENT for the STUB

if (out.BasePrice != null) {
    if (out.SpecialAdjPct != null) {
        return out.BasePrice * out.SpecialAdjPct
    }
} else {
    api.addWarning("Cannot calculate the Special Adjustment, because the Base Price is not available.")
    return null
}
