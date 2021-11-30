import groovy.transform.Field

@Field String TABLE_PRODUCT_COST = 'Food_ProductCost'
@Field String FIELD_VALID_FROM = 'attribute1'
@Field String FIELD_AVERAGE_COST = 'attribute2'
@Field String FIELD_CURRENCY = 'attribute3'

BigDecimal findCost(
        String sku,
        String currency,
        Date date = new Date()
){
    String dateAsString = date.format('yyyy-MM-dd')
    Filter filter = Filter.and(
            Filter.equal('name', TABLE_PRODUCT_COST),
            Filter.equal('sku', sku),
            Filter.equal(FIELD_CURRENCY, currency),
            Filter.lessOrEqual(FIELD_VALID_FROM, dateAsString)
    )

    return api.find(
            'PX',
            0,
            1,
            FIELD_VALID_FROM,
            [FIELD_AVERAGE_COST],
            filter
    ).find()?.getAt(FIELD_AVERAGE_COST) as BigDecimal
}