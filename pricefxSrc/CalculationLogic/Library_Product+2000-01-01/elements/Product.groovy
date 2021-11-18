
Map<String, Object> findProduct(String sku){
    def filter = Filter.equal('sku', sku)
    return api.find('P', 0, 1, null, null, filter)?.find()
}