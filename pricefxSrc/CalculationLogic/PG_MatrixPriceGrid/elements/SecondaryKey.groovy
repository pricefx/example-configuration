if (api.isDebugMode()) {

    /* "test" (i.e. Debug Mode) logic execution */

    final String INPUT_VOLUME_BREAK = "VolumeBreak"
    if (api.isSyntaxCheck()) {
        def volumeBreaks = api.findLookupTableValues("VolumeBreaks", "VolumeBreak")?.key3?.unique()
        api.inputBuilderFactory().createOptionEntry(INPUT_VOLUME_BREAK)
                .setOptions(volumeBreaks)
                .getInput()
    } else {
        return input[INPUT_VOLUME_BREAK]
    }


} else {

    /* "normal" logic execution */

    return api.getSecondaryKey()

}