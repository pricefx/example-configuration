def ctx = api.getDatamartContext()
def dm = ctx.getDatamart("Transaction")
ctx.dimFilterEntry(Const.INPUT_FIELD_YEAR, dm.getColumn("InvoiceDateYear"))
