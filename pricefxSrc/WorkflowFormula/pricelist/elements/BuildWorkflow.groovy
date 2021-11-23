workflow.addWatcherStep("Price Manager Check")
        .withUserGroupWatchers("Price_Manager")

if (out.ApprovalReasons) {
    workflow.addApprovalStep("Product Managers Approval")
            .withUserGroupApprovers("Product_Manager")
            .withMinApprovalsNeeded(2)
            .withReasons(out.ApprovalReasons.join(". "))
}

return null