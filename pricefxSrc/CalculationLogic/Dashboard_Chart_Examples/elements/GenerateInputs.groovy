if(!api.syntaxCheck){
    return
}

api.inputBuilderFactory().createUserEntry('gaugeValue')
        .setLabel('Gauge Value')
        .setMin(-1)
        .setMax(1)
        .setFormatType('PERCENT')
        .getInput()

return