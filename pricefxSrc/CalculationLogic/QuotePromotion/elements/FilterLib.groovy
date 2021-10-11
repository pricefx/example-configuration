import com.googlecode.genericdao.search.Filter

List<Filter> buildFilters(String contractTermType, String productId, String customerId) {

    def filters = [
        Filter.equal("ContractTermType", contractTermType), // look only for specific type

        Filter.equal("status", "ACTIVE"),

        /* select only Price Records valid at the Effective Date of the Quote */
        Filter.lessOrEqual("validAfter", api.targetDate()),
        Filter.greaterOrEqual("expiryDate", api.targetDate()),
    ]
    if (productId) {
        filters << Filter.or(
            api.productToRelatedObjectsFilter("PR", productId),
            Filter.isNull("productGroup") //this must be there, because the productGroup can be null, and productToRelatedObjectsFilter() does not cover that
        )
    }
    if (customerId) {
        filters << Filter.or(
            api.customerToRelatedObjectsFilter("PR", customerId),
            Filter.isNull("customerGroup") //this must be there, because the customerGroup can be null, and customerToRelatedObjectsFilter() does not cover that
        )
    }

    return filters
}