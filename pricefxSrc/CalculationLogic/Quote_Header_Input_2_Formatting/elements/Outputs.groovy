import net.pricefx.common.api.CalculationResultType

if (quoteProcessor.isPostPhase()) {

    def displaySettings = [numberOfFieldsPerLine: 3]
    quoteProcessor.addOrUpdateOutput(
            [
                    "resultName": "__UI_HeaderDisplaySettings",
                    "resultType": "OBJECT",
                    "result"    : displaySettings
            ]
    )


    for (int i = 1; i <= 4; i++) {
        quoteProcessor.addOrUpdateOutput(
                [
                        "resultName"    : "Output$i".toString(),
                        "resultLabel"   : "Output$i".toString(),
                        "resultType"    : CalculationResultType.SIMPLE,
                        "result"        : i
                ]
        )

    }


}