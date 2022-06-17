final Integer INITIAL_WIDTH = 600  // 600 pixels
final Integer INITIAL_HEIGHT = 200  // 200 pixels

ResultMatrix resultMatrix = createSampleResultMatrix()

// Sets initial width and height for the returned result matrix.
// Result matrix represents the portlet, so this becomes initial portlet dimensions
resultMatrix.withLayout(INITIAL_WIDTH, INITIAL_HEIGHT)  //<1>

return resultMatrix


/**
 * Sample result matrix, representing a portlet with data formatted in table
 * @return
 */
ResultMatrix createSampleResultMatrix() {
    def resultMatrix = api.newMatrix("Customer Id", "Net Margin %")

    resultMatrix.addRow(["Customer Id": "C1", "Net Margin %": 0.104])
    resultMatrix.addRow(["Customer Id": "C2", "Net Margin %": 0.044])
    resultMatrix.addRow(["Customer Id": "C3", "Net Margin %": 0.014])

    return resultMatrix
}