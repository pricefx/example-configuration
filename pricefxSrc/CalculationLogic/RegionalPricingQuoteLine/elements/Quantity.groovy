def INPUT_FIELD_NAME = "Quantity"

def qty = api.userEntry(INPUT_FIELD_NAME)
if (api.isSyntaxCheck()) {
    api.getParameter(INPUT_FIELD_NAME)?.setRequired(true)
}

return qty