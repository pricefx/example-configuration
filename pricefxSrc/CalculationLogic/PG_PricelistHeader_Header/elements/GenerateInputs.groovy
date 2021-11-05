// NOTE: the following code will be called in SyntaxCheck mode,
// because the whole execution of Pricelist Header logic is only in Syntax Check mode
api.inputBuilderFactory().createUserEntry("SpecialAdjPct")
        .setLabel("Enter Special Adjustment (in %)")
        .setFormatType("PERCENT")
        .getInput()

