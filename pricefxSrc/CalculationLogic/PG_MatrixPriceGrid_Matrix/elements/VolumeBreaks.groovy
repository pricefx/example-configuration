def region = input.Region  // input from the context
def businessUnit = api.product("BusinessUnit")  //SKU from the context

if (region != null && businessUnit != null) {

    def volumeBreaks = api.findLookupTableValues("VolumeBreaks", "VolumeBreak",
            Filter.equal("Region", region),
            Filter.equal("BusinessUnit", businessUnit)
    )?.key3

    return volumeBreaks

} else {
    api.throwException("Region was not specified or product's Business Unit not found.")
}