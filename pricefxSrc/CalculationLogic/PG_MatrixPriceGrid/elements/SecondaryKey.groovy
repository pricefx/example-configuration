if (!api.isDebugMode()) {
    /* "normal" logic execution */

    return api.getSecondaryKey()
} else {
    /* "test" (i.e. Debug Mode) logic execution */
    def volumeBreaks =
            api.findLookupTableValues("VolumeBreaks", "VolumeBreak")
                    ?.key3?.unique()

    if (api.isSyntaxCheck()) {
        api.option("VolumeBreak", volumeBreaks)
    } else {
        return input.VolumeBreak
    }
}