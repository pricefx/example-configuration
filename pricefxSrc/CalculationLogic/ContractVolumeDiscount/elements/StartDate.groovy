if (api.isDebugMode()) {
    api.global.startDate = api.inputBuilderFactory().createDateUserEntry("startDate").getInput()
}

return api.global.startDate
