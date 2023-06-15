final String INPUT_NAME_LISTPRICE = "ListPrice"
final String INPUT_NAME_DISCOUNT = "Discount"

if (api.isInputGenerationExecution()) {
    api.inputBuilderFactory().createUserEntry(INPUT_NAME_LISTPRICE).getInput()
    api.inputBuilderFactory().createUserEntry(INPUT_NAME_DISCOUNT).getInput()

    return
}


def listPrice = input[INPUT_NAME_LISTPRICE]
def discount = input[INPUT_NAME_DISCOUNT]

if (listPrice == null || discount == null) {
    return null
}

return listPrice - discount