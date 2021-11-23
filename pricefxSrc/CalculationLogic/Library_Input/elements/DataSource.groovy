import net.pricefx.formulaengine.scripting.inputbuilder.OptionInputBuilder

OptionInputBuilder buildDimensionInput(
        String inputName,
        String dataMartName,
        String dimensionColumnName
) {
    def datamart = libs.Library_Queries.DataMart
    def uniqueValues = datamart.getUniqueValues(
            dataMartName,
            dimensionColumnName
    )
    api.inputBuilderFactory()
            .createOptionEntry(inputName)
            .setOptions(uniqueValues)
}