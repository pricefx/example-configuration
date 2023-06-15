//if(!api.isInputGenerationExecution()){
//    return
//}

def dataSource = libs.Library_Input.DataSource

dataSource.buildDimensionInput(
        'Year',
        'Transaction',
        'InvoiceDateYear'
).getInput()

return

