def ctx = api.getDatamartContext()
def dm = ctx.getDatamart("Transaction")
def column = dm.getColumn("InvoiceDateYear")

return ctx.dimFilterEntry("Year", column)?.getValue()