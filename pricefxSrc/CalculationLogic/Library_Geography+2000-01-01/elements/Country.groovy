import groovy.transform.Field
import com.googlecode.genericdao.search.Filter

@Field final String TABLE_NAME_COUNTRY = 'CountryInfo'
@Field final String FIELD_COUNTRY_CODE = 'name'
@Field final String FIELD_COUNTRY_NAME = 'attribute1'
@Field final String FIELD_REGION_NAME = 'attribute2'

String findCountryName(String countryCode) {
    return api.vLookup(
            TABLE_NAME_COUNTRY,
            [FIELD_COUNTRY_NAME],
            [(FIELD_COUNTRY_CODE): countryCode]
    )?.getAt(FIELD_COUNTRY_NAME)
}

List<String> findAllCountryInfo() {
    return api.findLookupTableValues(TABLE_NAME_COUNTRY)
}

List<String> findAllCountryCodes() {
    return api.findLookupTableValues(
            TABLE_NAME_COUNTRY,
            [FIELD_COUNTRY_CODE],
            FIELD_COUNTRY_CODE
    )?.collect { row ->
        row[FIELD_COUNTRY_CODE] as String
    }
}

List<Map<String, Object>> findCountriesByRegion(String regionName, List<String> fields = null) {
    def filter = Filter.equal(FIELD_REGION_NAME, regionName)
    return api.findLookupTableValues(
            TABLE_NAME_COUNTRY,
            fields,
            FIELD_COUNTRY_NAME,
            filter
    )
}

Boolean isCountryInRegion(String countryCode, String region){
    def keys = [
            (FIELD_COUNTRY_CODE): countryCode
    ]
    api.vLookup(TABLE_NAME_COUNTRY, FIELD_REGION_NAME, keys) == region
}