import net.pricefx.common.api.InputType

// define a Section
def section = api.createConfiguratorEntry()

// add one dropdown input field
section.createParameter(InputType.OPTION, "ShipTo")
        .setValueOptions(
                api.namedEntities(api.findLookupTableValues("FreightSurcharge"))
                        ?.collect { it.Country }
                        ?.unique()
                        ?.sort()
        )

//return the Section definition. The logic Element containing this code must have DisplayMode set to Everywhere
return section