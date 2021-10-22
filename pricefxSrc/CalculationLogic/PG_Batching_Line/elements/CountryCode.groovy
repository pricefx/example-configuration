if (api.isDebugMode()) {

    final String = INPUT_COUNTRY_CODE = "CountryCode"
    if (api.isSyntaxCheck()) {
        api.inputBuilderFactory().createOptionEntry(INPUT_COUNTRY_CODE)
                .setOptions(
                        api.findLookupTableValues("CountryAdjustment", ["name"], "name")?.name
                )
                .getInput()
    } else {
        return input[INPUT_COUNTRY_CODE]
    }

} else {

    return api.getSecondaryKey()

}