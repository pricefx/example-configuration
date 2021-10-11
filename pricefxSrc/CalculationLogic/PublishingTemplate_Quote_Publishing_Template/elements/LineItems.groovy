out.Quote.lineItems.each { lineItem ->

    lineItem << lineItem.inputs.collectEntries { [(it.name): (it.value)] } //Quantity & SalesDiscountPct
    lineItem << lineItem.outputs.collectEntries { [(it.resultName): (it.result)] } //InvoicePrice & TotalInvoicePrice

    if (lineItem.SalesDiscountPct != null) {
        lineItem.SalesDiscountPct = lineItem.SalesDiscountPct * 100.0
        //the percentage value must be multiplied here, cannot do it in DOCX template
    }

}

return out.Quote.lineItems