if (api.isDebugMode()) {
    if (api.isSyntaxCheck()) {
        api.inputBuilderFactory().createDateUserEntry("startDate").getInput()
    } else {
        api.global.startDate = input.startDate
    }
}

return api.global.startDate
