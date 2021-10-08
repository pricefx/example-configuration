api.logInfo("ConfigurationWizard Configurator")

final String INPUT_NAME = "SampleInputField"

def valueFromUser = input[INPUT_NAME]
def message
if (!valueFromUser) {
    message = "<div style='margin:20px;color:red;'>Please enter some value</div>"
}


def inputField = api.inputBuilderFactory().createStringUserEntry(INPUT_NAME)
        .setLabel(INPUT_NAME)
        .setValue(valueFromUser)
//        .setRequired(true)
        .buildContextParameter()

def section = api.createConfiguratorEntry()
section.addParameter(inputField)
section.setMessage(message)


return section
