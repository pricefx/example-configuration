if (out.RebatePct == null) return

def actualSales = out.ActualSalesByCustomer as Map
def customerIds = actualSales.keySet()

def rebateRecord = api.currentItem()


payoutRecords.bulkLoadMode()

customerIds.each { customerId ->

    def rebateValue = (actualSales[customerId] ?: 0.0) * out.RebatePct

    def payoutRecord = [
            startDate : rebateRecord.startDate,
            endDate   : rebateRecord.endDate,
            payoutDate: rebateRecord.payoutDate,
            attribute1: customerId,
            attribute2: rebateValue,
            attribute3: "EUR",
            attribute4: out.RebatePct,
    ]

    payoutRecords.add(
            "Payout",
            "${rebateRecord.uniqueName}-${customerId}" as String,
            payoutRecord
    )
}


payoutRecords.flush()
