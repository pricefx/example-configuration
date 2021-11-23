//if(!api.syntaxCheck){
//    return
//}

def dataSource = libs.Library_Input.DataSource

dataSource.buildDimensionInput(
        'Year',
        'Transaction',
        'InvoiceDateYear'
).getInput()

return

