if (api.isInputGenerationExecution()) {
    // Declare input parameters, only in Input Generation mode

//     Quantity
    api.inputBuilderFactory().createIntegerUserEntry("Quantity")
            .setLabel("Required Quantity")
            .setRequired(true)
    // Limit values to be > 0
            .setInputType("range")
            .setMin(1)
    //build the input
            .getInput()

//     Sales Discount %
    api.inputBuilderFactory().createUserEntry("SalesDiscountPct")
            .setValue(0) // Set initial value
            .setFormatType("PERCENT")
            .setLabel("Sales Discount (%)")
            .setRequired(false)
    // limit the values to be between 0% and 100%
            .setInputType("range")
            .setMin(0)  // Min value
            .setMax(1)  // Max value ( 1.0 == 100 % )
    //build the input
            .getInput()

    // Prevent the following elements from being executed
    api.abortCalculation()
}