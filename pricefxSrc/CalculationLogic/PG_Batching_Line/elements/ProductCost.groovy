//added to STUB

def sku = api.product("sku")


/* if Batch not yet available or the SKU is not in the Current Batch, treat it as beginning of new batch */
def isNewBatch = api.global.currentBatch == null || !api.global.currentBatch.contains(sku)

/* when the new batch starts, pre-load the list of SKUs from the Batch into memory */
if (isNewBatch) {
    api.global.currentBatch =
            api.getBatchInfo()?.collect { it.first() }?.unique()
                    ?: ([sku] as Set)
}

/* when the new batch starts, do pre-load product costs (for all SKUs of the batch) into memory */
if (isNewBatch) {

    api.logInfo("NewBatchOfSKUs: ", api.jsonEncode(api.global.currentBatch))

    def rowIterator = api.stream(
            "PX3", "sku", ["sku", "attribute1"],
            Filter.equal("name", "ProductCost"),
            Filter.in("sku", api.global.currentBatch)
    )
    api.global.productCosts = rowIterator
            ?.collectEntries { [(it.sku): (it.attribute1 as BigDecimal)] }

    rowIterator.close()
}

return api.global.productCosts[sku]