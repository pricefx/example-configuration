import groovy.transform.Field

@Field String TABLE_PRODUCT_COST = 'Food_Product_Cost'
@Field String FIELD_TABLE_NAME = 'name' // Used to differentiate extensions that are stored in the same SQL table
@Field String FIELD_SKU = 'sku'
@Field String FIELD_VALID_FROM = 'attribute1'
@Field String FIELD_AVERAGE_COST = 'attribute2'

Map<String, Object> findProduct(String sku){
    def filter = Filter.equal(FIELD_SKU, sku)
    return api.find('P', 0, 1, null, null, filter)?.getAt(0)
}

BigDecimal findProductCost(String sku, Date date){
    def filters = [
            Filter.equal(FIELD_TABLE_NAME, TABLE_PRODUCT_COST),
            Filter.equal(FIELD_SKU, sku),
            Filter.greaterOrEqual(FIELD_VALID_FROM, date),
    ]
    return api.find(
            'PX',
            0,
            1,          // Only retrieve a single value
            FIELD_VALID_FROM,   // Use the most recent price
            [FIELD_AVERAGE_COST],
            *filters
    )?.getAt(0) as BigDecimal
}