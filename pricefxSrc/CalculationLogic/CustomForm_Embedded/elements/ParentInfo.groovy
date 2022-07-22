def formObjectMap = api.currentItem()
def parentTypedId = formObjectMap.parentTypedId


api.logInfo("CustomForm", "Parent Typed Id: ${parentTypedId}")


if (customFormProcessor.isPostPhase()) {

    Map myOutput = [
            resultName : "ParentTypedId",
            resultLabel: "Parent Typed Id",
            resultType : CalculationResultType.SIMPLE,
            result     : parentTypedId
    ]

    customFormProcessor.addOrUpdateOutput(myOutput)

}