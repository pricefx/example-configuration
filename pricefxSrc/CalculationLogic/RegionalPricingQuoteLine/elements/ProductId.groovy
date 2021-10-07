api.trace("currentItem", api.currentItem())

if (api.isDebugMode()) {
    return api.product("sku")
} else {
    return api.currentItem("sku")
}