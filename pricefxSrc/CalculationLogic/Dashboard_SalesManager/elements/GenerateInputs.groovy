generateInputs('Dashboard_SalesManager_Configurator')

void generateInputs(String configuratorLogicName){
    if(!api.syntaxCheck){
        return
    }

    api.inputBuilderFactory()
            .createConfiguratorInputBuilder(
                    'RootInput',
                    configuratorLogicName,
                    true)
            .getInput()

    api.abortCalculation()

    return
}