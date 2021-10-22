final String INPUT_REGION = "Region"

if (api.isSyntaxCheck()) {

    def regions = api.findLookupTableValues("Region")?.collect { it.name }?.sort()
    api.inputBuilderFactory().createOptionEntry(INPUT_REGION)
            .setOptions(regions)
            .getInput()

} else {

    return input[INPUT_REGION]

}


