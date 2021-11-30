import groovy.transform.Field
import com.googlecode.genericdao.search.Filter

@Field final String TABLE_COUNTRY = 'CountryInfo'
@Field final String FIELD_COUNTRY_CODE = 'name'
@Field final String FIELD_COUNTRY_NAME = 'attribute1'
@Field final String FIELD_REGION = 'attribute2'
@Field final String FIELD_CURRENCY = 'attribute8'

String findCountryName(String countryCode) {
    return api.vLookup(
            TABLE_COUNTRY,
            [FIELD_COUNTRY_NAME],
            [(FIELD_COUNTRY_CODE): countryCode]
    )?.getAt(FIELD_COUNTRY_NAME)
}

Map<String, String> findCountryCodeToName()  {
    return api.findLookupTableValues(
            TABLE_COUNTRY,
            [FIELD_COUNTRY_NAME, FIELD_COUNTRY_CODE],
            FIELD_COUNTRY_CODE,
    ).collectEntries { row ->
        [(row[FIELD_COUNTRY_CODE]): row[FIELD_COUNTRY_NAME]]
    }
}

List<String> findAllCountryCodes() {
    return api.findLookupTableValues(
            TABLE_COUNTRY,
            [FIELD_COUNTRY_CODE],
            FIELD_COUNTRY_CODE
    )?.collect { row ->
        row[FIELD_COUNTRY_CODE] as String
    }
}

List<Map<String, Object>> findCountriesByRegion(String regionName, List<String> fields = null) {
    def filter = Filter.equal(FIELD_REGION, regionName)
    return api.findLookupTableValues(
            TABLE_COUNTRY,
            fields,
            FIELD_COUNTRY_NAME,
            filter
    )
}

String findRegionByCountry(String countryCode){
    api.vLookup(TABLE_COUNTRY, [FIELD_REGION], [
            (FIELD_COUNTRY_CODE) : countryCode
    ])?.getAt(FIELD_REGION) as String
}

Boolean isCountryInRegion(String countryCode, String region){
    def keys = [
            (FIELD_COUNTRY_CODE): countryCode
    ]
    api.vLookup(TABLE_COUNTRY, FIELD_REGION, keys) == region
}
