api.logInfo("Creation Workflow Logic", "===================================")

api.logInfo("sku", api.product("sku"))

api.logInfo("inputs", input)

api.logInfo("currentItem", api.currentItem())
api.logInfo("currentItem class", api.currentItem()?.getClass())
api.logInfo("currentContext", api.currentContext())

api.logInfo("contextName", api.contextName())
api.logInfo("contextType", api.contextType())

api.logInfo("quoteType",api.currentItem("quoteType"))

api.logInfo("creationWorkflowStatus", api.currentItem("creationWorkflowStatus"))
api.logInfo("creationWorkflowCurrentStep", api.currentItem("creationWorkflowCurrentStep"))
api.logInfo("creationWorkflowStepLabel", api.currentItem("creationWorkflowStepLabel"))
api.logInfo("creationWorkflowStepCount", api.currentItem("creationWorkflowStepCount"))
