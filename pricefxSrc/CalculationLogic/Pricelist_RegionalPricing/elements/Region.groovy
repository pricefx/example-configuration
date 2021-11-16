import groovy.transform.Field

@Field final String INPUT_REGION = "Region"
@Field final String TABLE_NAME_REGION = "Region"

if (api.isSyntaxCheck()) {

    def regions = findAllRegions()
    api.inputBuilderFactory().createOptionEntry(INPUT_REGION)
            .setOptions(regions)
            .getInput()

} else {
    return input[INPUT_REGION]
}

List<String> findAllRegions() {
    return api.findLookupTableValues(TABLE_NAME_REGION)?.collect { it.name }?.sort()
}