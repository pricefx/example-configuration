if (api.isSyntaxCheck()) {
    // Declare input parameters, only in syntax check mode

    // Quantity
    api.integerUserEntry("Quantity")
    def quantityParam = api.getParameter("Quantity")
    quantityParam.setLabel("Required Quantity")
    quantityParam.setRequired(true)
    // Limit values to be > 0
    quantityParam.setConfigParameter("inputType", "range")
    quantityParam.setConfigParameter("from", 1) // Min value

    // Sales Discount %
    api.userEntry("SalesDiscountPct")
    def discountParam = api.getParameter("SalesDiscountPct")
    discountParam.setLabel("Sales Discount (%)")
    discountParam.setRequired(false)
    discountParam.setValue(0) // Set initial value
    discountParam.setConfigParameter("formatType", "PERCENT")
    // Limit values to be > 0 & < 1
    discountParam.setConfigParameter("inputType", "range")
    discountParam.setConfigParameter("from", 0) // Min value
    discountParam.setConfigParameter("to", 1) // Max value
}