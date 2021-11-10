// This creation workflow is supposed to be used only for quotes of type

final String QUOTE_CONTEXT_TYPE = "Q"
final String QUOTE_TYPE = "Creation Workflow Demo"

if (!(
        QUOTE_CONTEXT_TYPE == api.contextType()
                && QUOTE_TYPE == api.currentItem("quoteType")
)) {

    api.abortCalculation()

}