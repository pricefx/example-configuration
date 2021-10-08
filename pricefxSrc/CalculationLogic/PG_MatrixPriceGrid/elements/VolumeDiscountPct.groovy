keys = [
        Region      : input.Region,
        BusinessUnit: api.product("BusinessUnit"),
        VolumeBreak : out.SecondaryKey
]
return api.vLookup("VolumeBreaks", "Discount", keys)
