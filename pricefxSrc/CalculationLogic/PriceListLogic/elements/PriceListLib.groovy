BigDecimal marginAdj() {
    def productGroup = api.product("ProductGroup")
    return api.vLookup("MarginAdj", productGroup)
}

BigDecimal attributeAdj() {
    def productLifeCycle = api.product("ProductLifeCycle")
    return api.vLookup("AttributeAdj", "AttributeAdj", productLifeCycle)
}