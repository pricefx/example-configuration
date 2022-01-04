import net.pricefx.server.dto.calculation.ConfiguratorEntry

return createCountryInput()

ConfiguratorEntry createCountryInput() {
    def fieldset = api.createConfiguratorEntry()
    def countries = libs.Library_Geography.Country
    def countryCodeToName = countries.findCountryCodeToName()
    def allCountryCodes = countryCodeToName.keySet().toList()

    final String INPUT_COUNTRY_CODE = 'countryCode'

    fieldset.inputs = [
            api.inputBuilderFactory().createOptionEntry(INPUT_COUNTRY_CODE)
                    .setValue(input?.getAt(INPUT_COUNTRY_CODE))
                    .setLabel('Country')             // Label of the entire input
                    .setRequired(true)
                    .setOptions(allCountryCodes)    // Values of the options
                    .setLabels(countryCodeToName) // Labels of the options
                    .buildContextParameter() // Build the input
    ]

    return fieldset
}