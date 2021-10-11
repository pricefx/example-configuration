def startDateAsString = input.StartDate
def endDateAsString = input.EndDate

/*
    if the user does not specify a date range,
    we will use year which contains the target date of the rebate allocation DL process
*/
if (!startDateAsString || !endDateAsString) {
    def dmCalendar = api.getDatamartContext().calendar()
    def yearTimePeriod = dmCalendar.getTimePeriod(dmCalendar.getYear(api.targetDate()))
    startDateAsString = yearTimePeriod.getStartDate().format("yyyy-MM-dd")
    endDateAsString = yearTimePeriod.getEndDate().format("yyyy-MM-dd")
}

def filterForRRs = Filter.and(
        Filter.greaterOrEqual("startDate", startDateAsString),
        Filter.lessOrEqual("endDate", endDateAsString)
)

final String dmDateFieldName = "InvoiceDate"
final String sortRRByField = "startDate"
api.emitRebateRecords(dmDateFieldName, sortRRByField, filterForRRs)

return