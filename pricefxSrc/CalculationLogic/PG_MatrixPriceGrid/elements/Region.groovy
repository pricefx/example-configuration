if (api.isSyntaxCheck()) {

    def volumeBreaks = api.findLookupTableValues("VolumeBreaks", "Region")
            ?.key1?.unique()

    api.inputBuilderFactory().createOptionEntry("Region")
            .setOptions(volumeBreaks)
            .setRequired(true)
            .getInput()

}