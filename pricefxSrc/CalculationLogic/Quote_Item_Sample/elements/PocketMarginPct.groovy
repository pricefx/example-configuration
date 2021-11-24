if (null in [out.PocketMarginAbs, out.ListPrice]) {
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
String productGroup = Utils.currentProductGroup
def yellowThreshold = Utils.getYellowThreshold(productGroup)
def redThreshold = Utils.getRedThreshold(productGroup)
def criticalThreshold = Utils.getCriticalThreshold(productGroup)

// Check thresholds
if (criticalThreshold && pocketMarginPct < criticalThreshold) {
    api.criticalAlert("Pocket Margin % is unacceptable low")
} else if (redThreshold && pocketMarginPct < redThreshold) {
    api.redAlert("Pocket Margin % is very low")
} else if (yellowThreshold && pocketMarginPct < yellowThreshold) {
    api.yellowAlert("Pocket Margin % is low")
}

return pocketMarginPct