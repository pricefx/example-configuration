// NOTE: the following code will be called in InputGeneration mode,
// because the whole execution of Pricelist Header logic is only in Input Generation mode
api.inputBuilderFactory().createUserEntry("SpecialAdjPct")
        .setLabel("Enter Special Adjustment (in %)")
        .setFormatType("PERCENT")
        .getInput()

