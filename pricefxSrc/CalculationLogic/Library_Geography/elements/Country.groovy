import groovy.transform.Field
import com.googlecode.genericdao.search.Filter

@Field final String TABLE_NAME_COUNTRY = 'CountryInfo'
@Field final String COLUMN_NAME_COUNTRY_CODE = 'name'
@Field final String COLUMN_NAME_COUNTRY_NAME = 'attribute1'
@Field final String COLUMN_NAME_REGION_NAME = 'attribute2'

String findCountryName(String countryCode) {
    return api.vLookup(
            TABLE_NAME_COUNTRY,
            [COLUMN_NAME_COUNTRY_NAME],
            [(COLUMN_NAME_COUNTRY_CODE): countryCode]
    )?.getAt(COLUMN_NAME_COUNTRY_NAME)
}

List<String> findAllCountryInfo() {
    return api.findLookupTableValues(TABLE_NAME_COUNTRY)
}

List<String> findAllCountryCodes() {
    return api.findLookupTableValues(
            TABLE_NAME_COUNTRY,
            [COLUMN_NAME_COUNTRY_CODE],
            COLUMN_NAME_COUNTRY_CODE
    )?.collect { row ->
        row[COLUMN_NAME_COUNTRY_CODE] as String
    }
}

List<Map<String, Object>> findCountriesInRegion(String regionName) {
    def filter = Filter.equal(COLUMN_NAME_REGION_NAME, regionName)
    return api.findLookupTableValues(
            TABLE_NAME_COUNTRY,
            [COLUMN_NAME_COUNTRY_NAME],
            COLUMN_NAME_COUNTRY_NAME,
            filter
    )
}
