if (api.syntaxCheck) {
    api.inputBuilderFactory().createDateUserEntry("StartDate").getInput()
    api.inputBuilderFactory().createDateUserEntry("EndDate").getInput()

    api.abortCalculation()
}