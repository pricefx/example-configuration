if (api.isDebugMode()) {
    return api.customer("customerId")
} else {
    return api.input("Customer")
}