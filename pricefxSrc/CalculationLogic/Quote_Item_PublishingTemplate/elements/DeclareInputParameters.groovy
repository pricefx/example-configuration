if (api.isSyntaxCheck()) {
    // Declare input parameters, only in syntax check mode

//     Quantity
    api.inputBuilderFactory().createIntegerUserEntry("Quantity")
            .setLabel("Required Quantity")
            .setRequired(true)
            //.setInputType("range")  //not needed anymore
            .setFrom(1)      // Limit values to be > 0
            .getInput()

//     Sales Discount %
    api.inputBuilderFactory().createUserEntry("SalesDiscountPct")
            .setLabel("Sales Discount (%)")
            .setRequired(false)
            .setFormatType("PERCENT")
            .setValue(0) // Set initial value
            //.setInputType("range")  //not needed anymore
            .setFrom(0)  // Min value
            .setTo(1)  // Max value - regarding the real value kept in the input
            .getInput()

}