final String INPUT_NAME = "PromotionDiscount"
final String INPUT_LABEL = "Promotion Discount"

if (api.isSyntaxCheck()) {
    api.inputBuilderFactory().createUserEntry(INPUT_NAME)
            .setLabel(INPUT_LABEL)
            .setFormatType("PERCENT")
            .getInput()
} else {
    return input[INPUT_NAME]
}