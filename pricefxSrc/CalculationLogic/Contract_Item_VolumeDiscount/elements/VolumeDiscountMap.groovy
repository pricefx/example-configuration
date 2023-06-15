final String INPUT_NAME = "VolumeDiscount"
final String INPUT_LABEL = "Volume Discount"
final String COLUMN_QUANTITY = "Quantity"
final String COLUMN_DISCOUNT = "Discount %"

if (api.isInputGenerationExecution()) {
    api.inputBuilderFactory().createInputMatrix(INPUT_NAME)
            .setLabel(INPUT_LABEL)
            .setColumns([COLUMN_QUANTITY, COLUMN_DISCOUNT])
            .setColumnValueOptions()
            .getInput()

} else {
    /* [{Quantity=5, selected=false, Discount %=1},
        {Quantity=10, selected=false, Discount %=2},
        {Quantity=50, selected=false, Discount %=3}]
     */
    return input[INPUT_NAME]
            ?.findAll { (it[COLUMN_QUANTITY]) && (it[COLUMN_DISCOUNT]) }
            ?.collectEntries {
                [(it[COLUMN_QUANTITY] as BigDecimal): (
                        (it[COLUMN_DISCOUNT]) ? ((it[COLUMN_DISCOUNT] as BigDecimal) * 0.01) : null)]
            }

}
