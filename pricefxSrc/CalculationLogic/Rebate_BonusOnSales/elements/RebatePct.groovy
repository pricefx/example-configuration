final String INPUT_REBATE_PCT = "RebatePct"

if (api.isInputGenerationExecution()) {
    api.inputBuilderFactory().createUserEntry(INPUT_REBATE_PCT)
            .setLabel("Rebate %")
            .setFormatType("PERCENT")
            .setRequired(true)
            .getInput()
} else {
    return input[INPUT_REBATE_PCT]
}