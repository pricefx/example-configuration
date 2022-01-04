/**
 * Call this method in the first element of any logic to generate user inputs with the
 * specified form logic. The form should generate all user inputs. The call aborts input generation (syntax check execution).
 * @param formLogicName the name of a form logic
 * @param label
 */
void build(String formLogicName = null, String label = 'User Input') {
    if(!api.syntaxCheck){
        return
    }

    if(formLogicName){
        api.inputBuilderFactory()
                .createConfiguratorInputBuilder('userInput', formLogicName, true)
                .setLabel(label)
                .getInput()
    }

    api.abortCalculation()
}
