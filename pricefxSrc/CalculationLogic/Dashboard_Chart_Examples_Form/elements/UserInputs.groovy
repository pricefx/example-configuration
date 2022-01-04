final String GAUGE_VALUE = 'gaugeValue'
final String QUANTITY_INPUT = 'quantity'
final String INVOICE_PRICE_INPUT = 'invoicePrice'

def gaugeInput = api.inputBuilderFactory().createUserEntry(GAUGE_VALUE)
        .setValue(input[GAUGE_VALUE] as BigDecimal)
        .setLabel('Gauge Value')
        .setMin(-1)
        .setMax(1)
        .setFormatType('PERCENT')
        .buildContextParameter()

def gaugeFieldSet = api.createConfiguratorEntry()
gaugeFieldSet.message = 'Gauge'
gaugeFieldSet.inputs = [
        gaugeInput
]
return gaugeFieldSet