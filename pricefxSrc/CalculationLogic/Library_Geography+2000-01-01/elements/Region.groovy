import groovy.transform.Field

@Field final String TABLE_NAME_REGION = 'Region'

Map<String, Object> findRegion(String regionName){
    final keys = [
            name: regionName
    ]
    return api.vLookup(
            TABLE_NAME_REGION, // <1>
            null, // <2>
            keys // <3>
    )
}

List<String> findAllRegions() {
    return api.findLookupTableValues(TABLE_NAME_REGION, ['name'], 'name')
            ?.collect { it.name }
}
