import com.googlecode.genericdao.search.Filter
final String COLUMN_REVENUE = "InvoicePrice"
final String COLUMN_DATE = "InvoiceDate"

// Find the time period in previous year for the analysis
def startDate = api.parseDate("yyyy-MM-dd", out.StartDate)
startDate?.set(year: (startDate ? (startDate[Calendar.YEAR] - 1) : null))

def endDate = api.parseDate("yyyy-MM-dd", out.EndDate)
endDate?.set(year: (startDate ? (endDate[Calendar.YEAR] - 1) : null))


def ctx = api.getDatamartContext()
def q = ctx.newQuery(ctx.getDatamart("Transaction"))
        .select("SUM(${COLUMN_REVENUE})", COLUMN_REVENUE)
        .where(
                Filter.greaterOrEqual(COLUMN_DATE, startDate),
                Filter.lessOrEqual(COLUMN_DATE, endDate)
        )

if (out.ProductGroup) {
    q.where(out.ProductGroup)
}

if (out.CustomerGroup) {
    q.where(out.CustomerGroup)
}

return ctx.executeQuery(q)?.data?.getAt(0)?.getAt(COLUMN_REVENUE)
