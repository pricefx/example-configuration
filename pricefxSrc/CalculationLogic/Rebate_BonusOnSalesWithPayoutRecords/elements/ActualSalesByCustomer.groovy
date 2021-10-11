def dmCtx = api.getDatamartContext()
def dmTable = dmCtx.getDatamart("Transaction")

def query = dmCtx.newQuery(dmTable, true)

        .select("CustomerId", "CustomerId")
        .select("SUM(InvoicePrice)", "TotalRevenue")

        .where(out.CustomerGroup)
        .where(out.ProductGroup)

        .where(
                Filter.greaterOrEqual("InvoiceDate", out.StartDate),
                Filter.lessOrEqual("InvoiceDate", out.EndDateOrToday)
        )

def result = dmCtx.executeQuery(query)
return result?.data?.collectEntries { row ->
    [(row.CustomerId): row.TotalRevenue]
}
