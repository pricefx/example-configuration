if (customFormProcessor.isPostPhase()) {
    api.logInfo("CustomForm", "----------------------------")
    api.logInfo("CustomForm", "POST-phase")


    //find value entered by the user to the
    final String INPUT_FIELD_NAME = "MyInputField"
    BigDecimal myInputValue = input[INPUT_FIELD_NAME]

    api.logInfo("CustomForm", "User Entered Value ${myInputValue}")


    Map myOutput = [
            "resultName" : "MyResult",
            "resultLabel": "My Result",
            "resultType" : CalculationResultType.SIMPLE,
            "formatType" : FieldFormatType.MONEY_EUR,
    ]


    if (myInputValue != null) {

        //sample dummy calculation - to double the entered value
        BigDecimal myResult = 2.0 * myInputValue

        api.logInfo("CustomForm", "Calculated result: ${myResult}")

        myOutput += [
                result      : myResult,
                alertType   : null,
                alertMessage: null
        ]

    } else {

        api.logInfo("CF", "Critical problem - cannot calculate results")

        //Report critical problem for that output -> it will cause critical problem for the form
        myOutput += [
                result      : null,
                alertType   : "CRITICAL",
                alertMessage: "Cannot calculate the result, because of the missing input."
        ]

    }

    api.logInfo("CustomForm", "Output: ${myOutput}")

    customFormProcessor.addOrUpdateOutput(myOutput)


}