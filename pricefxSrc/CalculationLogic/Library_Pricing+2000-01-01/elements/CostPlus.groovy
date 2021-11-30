import groovy.transform.Field

@Field String TABLE_COUNTRY_MARKUP_COEFF = 'CountryAdjustment' // Used to differentiate extensions that are stored in the same SQL table
@Field String FIELD_COUNTRY_CODE = 'name'
@Field String FIELD_COUNTRY_MARKUP_COEFF = 'attribute1'

BigDecimal findCountryMarkupCoefficient(String countryCode){
    api.vLookup(TABLE_COUNTRY_MARKUP_COEFF, [FIELD_COUNTRY_MARKUP_COEFF], [
            (FIELD_COUNTRY_CODE): countryCode
    ])?.getAt(FIELD_COUNTRY_MARKUP_COEFF) as BigDecimal
}