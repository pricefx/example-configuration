def quoteTotalInvoicePrice = quote.outputs.find { it.resultName = "TotalInvoicePrice" }?.result
if (quoteTotalInvoicePrice == null) {
    api.throwException("Cannot build Workflow: Total Invoice Price is missing on the Quote Root folder.")
}

def approvalLevels = api.findLookupTableValues("ApprovalThreshold",
        Filter.equal("key2", out.Region),
        Filter.lessThan("attribute2", quoteTotalInvoicePrice)
)?.sort { a, b -> a.key1 <=> b.key1 }

api.trace("approvalLevels", approvalLevels)

approvalLevels.each { level ->
    def group = level.attribute1
    def revenueThreshold = level.attribute2
    workflow.addApprovalStep(group)
            .withUserGroupApprovers(group)
            .withReasons("${group} must approve, because Total Invoice Price is over ${revenueThreshold}.")
}
return null