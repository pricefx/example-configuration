if (api.isDebugMode()) {
    if (api.isSyntaxCheck()) {
        api.inputBuilderFactory().createDateUserEntry("endDate").getInput()
    } else {
        api.global.endDate = input.endDate
    }
}

return api.global.endDate
