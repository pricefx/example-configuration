import net.pricefx.common.api.InputType

def sku = input[Const.PRODUCT_INPUT_NAME]
def newDescription = input[Const.DESCRIPTION_INPUT_NAME]

def originalDescription = api.product("label", sku)

def message = """
<div style='color:#333333;white-space:normal; overflow-wrap: break-word;'>
    <br />
    Original label <em style='color:#555555'>${originalDescription}</em>
    has been changed to a NEW Label: <strong>${newDescription}</strong>
    for product sku: ${sku}.
    <br />
</div>
"""

def errorMessages = []
if (!sku) {
    errorMessages << "Product Id was not supplied!"
}
if (!newDescription) {
    errorMessages << "Description was not set or set empty!"
}

if (errorMessages) {
    message = "<div style='color:red;'>${errorMessages.join(' ')}</div>"
} else {
    api.update("P", ["sku": sku, "label": newDescription])  // majority of logics cannot do modification of data. It's a priviledge of the Execution logic.
}


def formSection = api.createConfiguratorEntry()
formSection.setMessage(message)


def button = formSection
        .createParameter(InputType.BUTTON, "OpenProducts")
        .setLabel(">> Open Product Table and verify your change")
button.addParameterConfigEntry("targetPage", "productsPage")


return formSection