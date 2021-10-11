final String INPUT_REBATE_PCT = "RebatePct"

if (api.isSyntaxCheck()) {
    api.userEntry(INPUT_REBATE_PCT)
    api.getParameter(INPUT_REBATE_PCT)
            .setConfigParameter("formatType", "PERCENT")
            .setRequired(true)
            .setLabel("Rebate %")
} else {
    return input[INPUT_REBATE_PCT]
}