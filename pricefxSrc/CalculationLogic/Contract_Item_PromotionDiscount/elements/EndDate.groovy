if (api.isDebugMode()) {
    if (api.isInputGenerationExecution()) {
        api.inputBuilderFactory().createDateUserEntry("endDate").getInput()
    } else {
        api.global.endDate = input.endDate
    }
}

return api.global.endDate
