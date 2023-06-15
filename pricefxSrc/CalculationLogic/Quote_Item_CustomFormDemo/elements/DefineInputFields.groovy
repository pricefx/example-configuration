//define some input field

if (api.isInputGenerationExecution()) {

    api.inputBuilderFactory()
            .createUserEntry("MyInputField")
            .getInput()

}