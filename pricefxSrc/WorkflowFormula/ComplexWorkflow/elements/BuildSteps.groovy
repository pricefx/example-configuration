def totalInvoicePrice = 0.0

quote.lineItems.findAll {
    !it.folder
}.each { lineItem ->
    BigDecimal lineItemTotalInvoicePrice = lineItem.outputs.find {
        it.resultName == "TotalInvoicePrice"
    }?.result
    if(!lineItemTotalInvoicePrice){
        api.throwException("Unable to build workflow. Unable to calculate Total " +
                "Invoice Price for entire quote. Missing for row ${lineItem.sku}")
    }
    totalInvoicePrice += lineItemTotalInvoicePrice
}

def approvalLevels = api.findLookupTableValues("ApprovalLevelsRevenue")

approvalLevels.sort {
    it.name
}.each { level ->
    def treshold = level.attribute1
    def userGroup = level.attribute2

    if (totalInvoicePrice >= treshold) {
        workflow.addApprovalStep(userGroup)
                .withReasons("Total Invoice Price > "
                        + (treshold as String) + "EUR")
                .withUserGroupApprovers(userGroup)
                .withMinApprovalsNeeded(1)
    }
}