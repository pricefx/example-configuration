import groovy.transform.Field

@Field String TABLE_NAME_PRODUCT_COST = 'Food_ProductCost'
@Field String COLUMN_NAME_VALID_FROM = 'attribute1'
@Field String COLUMN_NAME_AVERAGE_COST = 'attribute2'
@Field String COLUMN_NAME_CURRENCY = 'attribute3'

BigDecimal findCost(
        String sku,
        String currency,
        String date = new Date()
){
    String dateAsString = date.format('yyyy-MM-dd')
    Filter filter = Filter.and(
            Filter.equal('name', TABLE_NAME_PRODUCT_COST),
            Filter.equal('sku', sku),
            Filter.equal(COLUMN_NAME_CURRENCY, currency),
            Filter.lessOrEqual(COLUMN_NAME_VALID_FROM, dateAsString)
    )

    return api.find(
            'PX',
            0,
            1,
            COLUMN_NAME_VALID_FROM,
            [COLUMN_NAME_AVERAGE_COST],
            filter
    ).find()?.getAt(COLUMN_NAME_AVERAGE_COST) as BigDecimal
}