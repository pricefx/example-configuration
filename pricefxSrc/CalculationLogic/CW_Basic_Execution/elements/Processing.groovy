final String INPUT_NAME = "SampleInputField"

def valueFromUser = input[INPUT_NAME]


api.logInfo("ConfigurationWizard Execution received:", valueFromUser)


def section = api.createConfiguratorEntry()
section.setMessage("You entered: '${valueFromUser}'")


return section




