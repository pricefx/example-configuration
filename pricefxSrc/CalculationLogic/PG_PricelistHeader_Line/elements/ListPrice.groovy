if (out.BasePrice == null
        || out.MarginAdjAbs == null
        || out.AttributeAdjAbs == null
) {
    api.addWarning("List Price cannot be calculated: missing parameter(s).")
    return null
}

return out.BasePrice + out.MarginAdjAbs + out.AttributeAdjAbs + (out.SpecialAdjAbs ?: 0.0) //TODO remove the SPecialAdjAbs for the STUB