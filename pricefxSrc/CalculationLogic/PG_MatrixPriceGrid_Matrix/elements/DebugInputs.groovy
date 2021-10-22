if (api.isDebugMode() && api.isSyntaxCheck()) {

    def volumeBreaks = api.findLookupTableValues("VolumeBreaks", "Region")?.key1?.unique()

    api.inputBuilderFactory().createOptionEntry("Region")
            .setOptions(volumeBreaks)
            .getInput()

}