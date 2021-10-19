def INPUT_FIELD_NAME = "RequestedPrice"

def reqPrice = api.userEntry(INPUT_FIELD_NAME)
if (api.isSyntaxCheck()) {
    api.getParameter(INPUT_FIELD_NAME)?.setLabel("RequestedPrice")
}

return reqPrice