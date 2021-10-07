if (out.PocketMarginAbs == null
        || out.ListPrice == null) {
    api.addWarning("Pocket Margin % cannot be calculated: missing PocketMargin or ListPrice")
    return null
}

if (out.ListPrice == 0) {
    api.addWarning("List Price is 0, which means that Pocket Margin cannot be " +
            "calculated with fraction, since this would lead to division by 0")
    return null
}

return out.PocketMarginAbs / out.ListPrice