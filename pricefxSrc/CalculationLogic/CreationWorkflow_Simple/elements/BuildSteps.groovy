def step1 = api.newCreationWorkflowStep()
        .withLabel("My CW Step 1")
        .withUserAssignee("admin")

def step2 = api.newCreationWorkflowStep()
        .withLabel("My CW Step 2")
        .withUserAssignee("admin")

def step3 = api.newCreationWorkflowStep()
        .withLabel("My CW Step 3")
        .withUserAssignee("admin")

return api.newCreationWorkflow()
        .withSteps(step1, step2, step3)