if (api.isDebugMode()) {
    api.global.endDate = api.inputBuilderFactory().createDateUserEntry("endDate").getInput()
}

return api.global.endDate
