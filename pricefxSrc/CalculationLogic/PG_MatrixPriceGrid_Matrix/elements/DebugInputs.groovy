if (api.isDebugMode()) {

    def volumeBreaks =
            api.findLookupTableValues("VolumeBreaks", "Region")
                    ?.key1?.unique()

    if (api.isSyntaxCheck()) {
        api.option("Region", volumeBreaks)
    }

}