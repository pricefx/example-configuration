if (out.PocketMarginAbs == null
        || out.ListPrice == null) {
    api.addWarning("Pocket Margin % cannot be calculated: missing parameter(s)")
    return null
}

if (out.ListPrice == 0) {
    api.addWarning("List Price is 0, which means that Pocket Margin cannot be " +
            "calculated with fraction, since this would lead to division by 0")
    return null
}

def pocketMarginPct = out.PocketMarginAbs / out.ListPrice

// Fetch thresholds
String productGroup = api.product("ProductGroup")
String thresholdTableName = "PocketMarginAlertThreshold"
def yellowThreshold = api.vLookup(thresholdTableName, "Threshold", productGroup, "Yellow")
def redThreshold = api.vLookup(thresholdTableName, "Threshold", productGroup, "Red")
def criticalThreshold = api.vLookup(thresholdTableName, "Threshold", productGroup, "Critical")

// Check thresholds
if (criticalThreshold && pocketMarginPct < criticalThreshold) {
    api.criticalAlert("Pocket Margin % is unacceptable low")
} else if (redThreshold && pocketMarginPct < redThreshold) {
    api.redAlert("Pocket Margin % is very low")
} else if (yellowThreshold && pocketMarginPct < yellowThreshold) {
    api.yellowAlert("Pocket Margin % is low")
}

return pocketMarginPct