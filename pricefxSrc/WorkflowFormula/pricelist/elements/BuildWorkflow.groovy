workflow.addWatcherStep("Price Manager Check")
        .withUserGroupWatchers("PriceManager")

if (out.ApprovalReasons) {
    workflow.addApprovalStep("Product Managers Approval")
            .withUserGroupApprovers("ProductManager")
            .withMinApprovalsNeeded(2)
            .withReasons(out.ApprovalReasons.join(". "))
}

return null