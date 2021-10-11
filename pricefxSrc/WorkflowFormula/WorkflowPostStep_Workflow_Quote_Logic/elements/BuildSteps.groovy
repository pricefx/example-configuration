workflow.addApprovalStep("Managers")
        .withUserGroupApprovers("Price_Manager", "Product_Manager")
        .withMinApprovalsNeeded(1)
        .withPostStepLogic("WorkflowPostStep_PostStep_Logic")


workflow.addApprovalStep("VP Sales")
        .withUserGroupApprovers("VP_Sales")
