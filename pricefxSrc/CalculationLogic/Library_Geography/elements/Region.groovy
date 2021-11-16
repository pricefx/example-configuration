import groovy.transform.Field

@Field final String TABLE_NAME_REGION = 'Region'

Map<String, Object> findRegion(String region){
    final keys = [
            name: region
    ]
    return api.vLookup(
            TABLE_NAME_REGION, // <1>
            null, // <2>
            keys // <3>
    )
}

List<String> findAllRegions() {
    return api.findLookupTableValues(TABLE_NAME_REGION)
            ?.collect { it.name }
            ?.sort()
}