if (!api.isInputGenerationExecution()) {
    return
}

//build the button, which opens the Configurator form popup windows
api.inputBuilderFactory()
        .createConfiguratorInputBuilder(Constants.CONFIGURATOR_INPUT_NAME, Constants.CONFIGURATOR_LOGIC_NAME, false)
        .setLabel("Configure the Delivery")
        .getInput()
