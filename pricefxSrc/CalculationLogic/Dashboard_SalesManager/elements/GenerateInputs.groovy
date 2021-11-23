if(!api.syntaxCheck){
    return
}

def dataSourceInputs = libs.Library_Input.DataSource

dataSourceInputs.buildDimensionInput(
        'Year',
        'Transaction',
        'InvoiceDateYear'
).getInput()


return