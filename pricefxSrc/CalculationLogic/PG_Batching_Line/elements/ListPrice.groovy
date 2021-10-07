if (out.BasePrice == null
        || out.MarginAdjAbs == null
        || out.AttributeAdjAbs == null
        || out.CountryAdjAbs == null
) {
    api.addWarning("List Price cannot be calculated: missing parameter(s).")
    return null
}

return out.BasePrice + out.MarginAdjAbs + out.AttributeAdjAbs + out.CountryAdjAbs