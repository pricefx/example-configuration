import net.pricefx.server.dto.calculation.ConfiguratorEntry

ConfiguratorEntry imageFieldSet(String sku, String alt){
    def imageFieldSet = api.createConfiguratorEntry()

    // Add a dummy input, or the backend will throw an Exception
    def dummyInput = api.inputBuilderFactory().createHiddenEntry(sku).buildContextParameter()
    imageFieldSet.inputs = [dummyInput]

    String partition = api.currentPartitionName()
    def productImageUrl = "/pricefx/${partition}/productimages.get/${sku}?predefinedSize=enlarged_thumbnail"
    imageFieldSet.message = """<img src="$productImageUrl" alt="$alt"/>"""

    return imageFieldSet
}