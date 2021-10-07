/**
 * This element returns the Matrix2D found in the DatamartQueryResult
 */

def ctx = api.getDatamartContext()
def dm = ctx.getDatamart("Transaction")

def query = ctx.newQuery(dm, true)
        .select("BusinessUnit")
        .select("ProductGroup")
        .select("SUM(InvoicePrice)", "Revenue")
        .orderBy("BusinessUnit", "ProductGroup")

query.setOptions([currency: out.Currency])

def queryResult = ctx.executeQuery(query)

return queryResult?.getData()
