import net.pricefx.common.api.FieldFormatType

final MATRIX_COLUMN_CUSTOMER_ID = "Customer Id"
final MATRIX_COLUMN_REVENUE = "Revenue"

def filters = []
if (input[Const.INPUT_FIELD_YEAR]) {
    filters.add(Filter.equal("InvoiceDateYear", input[Const.INPUT_FIELD_YEAR]))
}

def ctx = api.getDatamartContext()
def dm = ctx.getDatamart("Transaction")
def q = ctx.newQuery(dm, true)
        .select("CustomerId", MATRIX_COLUMN_CUSTOMER_ID)
        .select("CustomerName")
        .select("SUM(InvoicePrice)", MATRIX_COLUMN_REVENUE)
        .where(*filters)
        .orderBy("$MATRIX_COLUMN_REVENUE DESC")
        .setMaxRows(10)

def queryResult = ctx.executeQuery(q)
def resultMatrix = queryResult?.getData()?.toResultMatrix()

resultMatrix?.setColumnFormat(MATRIX_COLUMN_REVENUE, FieldFormatType.MONEY_EUR)

// Add reaction to the user click/selection of the table Row
resultMatrix?.onRowSelection()
        // raise an Event with given name
        ?.triggerEvent(api.dashboardWideEvent(Const.EVENT_NAME_SELECT_CUSTOMER))
        // add data from the selected Matrix row to the Event's attributes
        ?.withColValueAsEventDataAttr(MATRIX_COLUMN_CUSTOMER_ID, Const.EVENT_ATTRIBUTE_CUSTOMER_ID)

return resultMatrix