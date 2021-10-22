final String INPUT_NAME_REBATE = "Rebate"
final String INPUT_NAME_INVOICE_PRICE = "InvoicePrice"
final String INPUT_NAME_TRANSACTION_ID = "TransactionId"


if (api.isSyntaxCheck()) {
    api.inputBuilderFactory().createUserEntry(INPUT_NAME_REBATE).getInput()
    api.inputBuilderFactory().createUserEntry(INPUT_NAME_INVOICE_PRICE).getInput()
    // api.inputBuilderFactory().createUserEntry(INPUT_NAME_TRANSACTION_ID).getInput()
    return
}


/* read data from Transaction row */
BigDecimal tRebateSum = input[INPUT_NAME_REBATE] ?: 0.0
BigDecimal tInvoicePrice = input[INPUT_NAME_INVOICE_PRICE]


if (tInvoicePrice == null) {
    api.addWarning("The transaction's invoice price is missing: $tInvoicePrice")
    return
}

/* read data from the Rebate Record */
def rebateRecord = api.currentItem()
if (api.isDebugMode()) {
    // Only for testing: rebate record will not be available as currentItem
    rebateRecord = api.find("RR", 0, 1, "uniqueName")?.getAt(0)
}

//api.logInfo("RR vs TransactionId", "${rebateRecord?.uniqueName} - $transactionId")

BigDecimal rTotalInvoicePrice = rebateRecord?.attribute1
BigDecimal rRebateAmount = rebateRecord?.attribute2

if (rTotalInvoicePrice == null || rRebateAmount == null) {
    api.addWarning(
            "Failed to calculate Rebate for Rebate Record ${rebateRecord?.uniqueName}," +
                    " because the rebate record's rebate amount and/or total invoice price are/is missing."
    )
    return
}

if (rTotalInvoicePrice == 0.0) {
    // Special case where the term is mathematically undefined.
    return tRebateSum + rRebateAmount
}

// Add term to the sum
return tRebateSum + tInvoicePrice * (rRebateAmount / rTotalInvoicePrice)