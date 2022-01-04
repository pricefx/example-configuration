import groovy.transform.Field
import net.pricefx.server.dto.calculation.ConfiguratorEntry

@Field final String INPUT_COUNTRY_CODE = 'countryCode'

return createCountryInput()

ConfiguratorEntry createCountryInput() {
    // Libs
    def countries = libs.Library_Geography.Country

    def fieldset = api.createConfiguratorEntry()
    def countryCodeToName = countries.findCountryCodeToName()
    def allCountryCodes = countryCodeToName.keySet().toList()

    fieldset.inputs = [
            api.inputBuilderFactory().createOptionEntry(INPUT_COUNTRY_CODE)
                    .setValue(input?.getAt(INPUT_COUNTRY_CODE))
                    .setLabel('Country')             // Label of the whole input
                    .setRequired(true)
                    .setOptions(allCountryCodes)    // Values of the options
                    .setLabels(countryCodeToName) // Labels of the options
                    .buildContextParameter() // Build the input
    ]

    return fieldset
}