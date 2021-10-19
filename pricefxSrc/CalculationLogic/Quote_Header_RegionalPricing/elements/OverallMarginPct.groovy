if (quoteProcessor.isPrePhase()) return

api.trace("q", quoteProcessor.quoteView)

def sumMargin = 0.0
def sumInvoice = 0.0
def overallMarginPct = null
def warnings = []

for (qli in quoteProcessor.quoteView.lineItems) {
    if (qli.folder) continue
    api.trace("qli", qli)
    def quantity = qli?.inputs?.find { it.name == "Quantity" }?.value
    def invoicePrice = qli?.outputs?.find { it.resultName == "InvoicePrice" }?.result
    def margin = qli?.outputs?.find { it.resultName == "Margin" }?.result

    if (null in [quantity, invoicePrice, margin]) {
        warnings.add("Cannot calculate Overall Margin % because line with SKU: " + (qli?.sku) + " does not have either Quantity, InvoicePrice or Margin calculated.")
        break
    }

    sumMargin += margin * quantity
    sumInvoice += invoicePrice * quantity
}

if (warnings.size() == 0) {
    if (sumInvoice != 0) {
        overallMarginPct = sumMargin / sumInvoice
    } else {
        // api.addWarning("Cannot calculate Overall margin % because SUM of the line items invoice prices is zero.")
        warnings.add("Cannot calculate Overall margin % because SUM of the line items invoice prices is zero.")
    }
}
def marginPctOutput = ["resultName" : "MarginPct",
                       "resultLabel": "Margin %",
                       "result"     : overallMarginPct,
                       "formatType" : "PERCENT",
                       "resultType" : "SIMPLE"]
if (warnings) marginPctOutput["warnings"] = warnings

quoteProcessor.addOrUpdateOutput(marginPctOutput)

api.trace("overallMarginPct", overallMarginPct)
return null