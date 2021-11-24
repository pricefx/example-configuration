import groovy.transform.Field

@Field String TABLE_NAME_THRESHOLDS = "PocketMarginAlertThreshold"

BigDecimal getYellowThreshold(String productGroup) {
    api.vLookup(TABLE_NAME_THRESHOLDS, 'Threshold', productGroup, 'Yellow') as BigDecimal
}

BigDecimal getRedThreshold(String productGroup) {
    api.vLookup(TABLE_NAME_THRESHOLDS, 'Threshold', productGroup, 'Red') as BigDecimal
}

BigDecimal getCriticalThreshold(String productGroup) {
    api.vLookup(TABLE_NAME_THRESHOLDS, 'Threshold', productGroup, 'Critical') as BigDecimal
}

String getCurrentProductGroup(){
    api.product("ProductGroup") as String
}