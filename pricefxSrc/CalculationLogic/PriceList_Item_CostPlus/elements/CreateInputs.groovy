import groovy.transform.Field

/// Only execute in input-creation mode
if(!api.syntaxCheck){
    return
}

createCountryInput()

// Prevent following elements from being executed in input-creation mode
api.abortCalculation()
return

void createCountryInput(){
    def countries = libs.Library_Geography.Country
    def countryCodeToName = countries.findCountryCodeToName()
    def allCountryCodes = countryCodeToName.keySet().toList()

    api.inputBuilderFactory().createOptionEntry('countryCode')
            .setLabel('Country')             // Label of the entire input
            .setRequired(true)
            .setOptions(allCountryCodes)    // Values of the options
            .setLabels(countryCodeToName) // Labels of the options
            .getInput() // Build the input
}