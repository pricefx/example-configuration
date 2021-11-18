import com.googlecode.genericdao.search.Filter

final String COLUMN_REVENUE = "InvoicePrice"
final String COLUMN_DATE = "InvoiceDate"

// Find the time period in previous year for the analysis
def startDate = api.parseDate("yyyy-MM-dd", out.StartDate)
startDate?.set(year: (startDate ? (startDate[Calendar.YEAR] - 1) : null))

def endDate = api.parseDate("yyyy-MM-dd", out.EndDate)
endDate?.set(year: (startDate ? (endDate[Calendar.YEAR] - 1) : null))

def dataMartContext = api.getDatamartContext()
def q = dataMartContext.newQuery(dataMartContext.getDatamart("Transaction"))
        .select("SUM(${COLUMN_REVENUE})", COLUMN_REVENUE)
        .where(
                Filter.greaterOrEqual(COLUMN_DATE, startDate),
                Filter.lessOrEqual(COLUMN_DATE, endDate)
        )

return dataMartContext.executeQuery(q)?.data?.find()?.getAt(COLUMN_REVENUE)
