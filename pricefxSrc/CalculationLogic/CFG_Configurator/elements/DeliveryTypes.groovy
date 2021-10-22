def filters = []
def country = input[Const.INPUT_NAME_SHIP_TO]
if (country) {
    filters << Filter.equal(Const.FIELD_COUNTRY, country)
}
api.findLookupTableValues(Const.LOOKUP_FREIGHT_SURCHARGE, [Const.FIELD_DELIVERY_TYPE], Const.FIELD_DELIVERY_TYPE, *filters)
        .inject([]) { countries, map -> countries + map.collect { it.value } }
        .unique()