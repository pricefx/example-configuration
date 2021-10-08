if (out.BasePrice == null
        || out.MarginAdjPct == null) {
    api.addWarning("Margin Adjustment cannot be calculated: missing parameter(s)")
    return null
}

if (out.MarginAdjPct == 1) {
    api.addWarning("Margin Adjustment % cannot be 100% -> division by 0")
    return null
}

return out.BasePrice * out.MarginAdjPct / (1 - out.MarginAdjPct)