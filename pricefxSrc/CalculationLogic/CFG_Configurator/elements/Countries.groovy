api.findLookupTableValues(Const.LOOKUP_FREIGHT_SURCHARGE, [Const.FIELD_COUNTRY], Const.FIELD_COUNTRY)
        .inject([]) { countries, map -> countries + map.collect { it.value } }
        .unique()
