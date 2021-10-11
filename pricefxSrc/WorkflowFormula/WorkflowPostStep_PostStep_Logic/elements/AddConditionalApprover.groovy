if (workflowHistory.activeStep.approved && "Managers" == workflowHistory.activeStep.uniqueName) {

    api.logInfo("workflowHistory.activeStep", api.jsonEncode(workflowHistory.activeStep))

    if ("Price_Manager" in workflowHistory.activeStep.executedByUsers[0].allGroups.uniqueName) {
        currentWorkflow.insertApprovalStep("Sales Manager")
                .withUserGroupApprovers("Sales_Manager")
    }

}

