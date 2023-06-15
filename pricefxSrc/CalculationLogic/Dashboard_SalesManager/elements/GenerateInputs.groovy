generateInputs('Dashboard_SalesManager_Configurator')

void generateInputs(String configuratorLogicName){
    if(!api.isInputGenerationExecution()){
        return
    }

    api.inputBuilderFactory()
            .createConfiguratorInputBuilder(
                    'Filters',
                    configuratorLogicName,
                    true
            )
            .getInput()

    api.abortCalculation()

    return
}