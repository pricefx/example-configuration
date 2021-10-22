def dmCtx = api.getDatamartContext()

def dmTable = dmCtx.getDatamart("Transaction")
def q = dmCtx.newQuery(dmTable, true)
q.select("SUM(Quantity)", "Quantity")
        .where(Filter.equal("CustomerId", out.CustomerId))
        .where(Filter.equal("ProductId", out.ProductId))
//q.setOptions(["currency":"USD"])

def result = dmCtx.executeQuery(q)

//return result?.data?.toResultMatrix()
def quantity = result?.data?.getValue(0, 0)
if (quantity == null) {
    api.addWarning("No historical quantity sold")
    return null
}

return quantity