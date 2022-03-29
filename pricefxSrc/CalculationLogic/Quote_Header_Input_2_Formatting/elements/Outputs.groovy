if (quoteProcessor.isPostPhase()) {

    def displaySettings = [numberOfFieldsPerLine: 3]

    quoteProcessor.addOrUpdateOutput(
            [
                    "resultName": "__UI_HeaderDisplaySettings",
                    "resultType": "OBJECT",
                    "result"    : displaySettings
            ]
    )

}