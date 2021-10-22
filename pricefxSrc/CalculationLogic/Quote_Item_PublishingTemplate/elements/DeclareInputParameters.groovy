if (api.isSyntaxCheck()) {
    // Declare input parameters, only in syntax check mode

//     Quantity
    api.inputBuilderFactory().createIntegerUserEntry("Quantity")
            .setInputType("range")
            .setMin(1)      // Limit values to be > 0
            .setLabel("Required Quantity")
            .setRequired(true)
            .getInput()

//     Sales Discount %
    api.inputBuilderFactory().createUserEntry("SalesDiscountPct")
            .setValue(0) // Set initial value
            .setInputType("range")
            .setMin(0)  // Min value
            .setMax(1)  // Max value
            .setFormatType("PERCENT")
            .setLabel("Sales Discount (%)")
            .setRequired(false)
            .getInput()

}