import groovy.transform.Field
import net.pricefx.server.dto.calculation.ConfiguratorEntry
import net.pricefx.server.dto.calculation.ContextParameter

return api.createConfiguratorEntryArray(timeFieldSet, countryFieldSet)

@Field String INPUT_YEAR = 'year'
@Field String INPUT_REGION = 'region'
@Field String INPUT_COUNTRY = 'country'

// Methods for creating field sets

ConfiguratorEntry getTimeFieldSet(){
    def fieldSet = api.createConfiguratorEntry()
    fieldSet.message = 'Filter by Year'
    fieldSet.inputs = [yearInput]
    return fieldSet
}

ConfiguratorEntry getCountryFieldSet(){
    def fieldSet = api.createConfiguratorEntry()
    fieldSet.message = 'Filter by Country'
    fieldSet.inputs = regionValue ? [regionInput, countryInput] : [regionInput]
    return fieldSet
}

// Methods for creating inputs

ContextParameter getYearInput() {
    // Lib
    def dataMartLib = libs.Library_Queries.DataMart

    def allYears = dataMartLib.getUniqueValues('Transaction', 'InvoiceDateYear')
    return api.inputBuilderFactory().createOptionEntry(INPUT_YEAR)
            .setValue(yearValue)
            .setOptions(allYears)
            .setLabel('Year')
            .buildContextParameter()
}

ContextParameter getRegionInput() {
    // Lib
    def regionLib = libs.Library_Geography.Region

    def allRegions = regionLib.findAllRegions()
    return api.inputBuilderFactory().createOptionEntry(INPUT_REGION)
            .setOptions(allRegions)
            .setValue(regionValue)
            .buildContextParameter()
}

ContextParameter getCountryInput() {
    // Lib
    def countryLib = libs.Library_Geography.Country

    def countryInfo = countryLib.findCountriesByRegion(regionValue)
    Map<String, String> countryCode2CountryName = countryInfo.collectEntries { row ->
        [(row[countryLib.FIELD_COUNTRY_CODE]): row[countryLib.FIELD_COUNTRY_NAME]]
    }
    def values = countryCode2CountryName.keySet().toList()
    def value2Label = countryCode2CountryName
    // If the user changed the region, then reset the value
    def newCountry = countryLib.isCountryInRegion(countryValue, regionValue) ? countryValue : null

    return api.inputBuilderFactory().createOptionEntry('country')
            .setOptions(values)
            .setLabels(value2Label)
            .setValue(newCountry)
            .buildContextParameter()
}

// Methods for reading user input values

String getYearValue() {
    return input[INPUT_YEAR] as String
}

String getRegionValue() {
    return input[INPUT_REGION] as String
}

String getCountryValue() {
    return input[INPUT_COUNTRY] as String
}