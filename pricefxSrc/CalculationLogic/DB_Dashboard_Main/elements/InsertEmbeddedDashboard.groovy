final String EMBEDDED_DASHBOARD_INPUT_FIELD_YEAR = "Year"
final String EMBEDDED_DASHBOARD_INPUT_FIELD_CUSTOMER_ID = "CustomerId"

return api.dashboard('DASH_Embedded')
        // pass value of filter from Main to the Embedded dashboard
        .setParam(EMBEDDED_DASHBOARD_INPUT_FIELD_YEAR, input[Const.INPUT_FIELD_YEAR])
        .showEmbedded()
        //embedded dashboard will listen to this Event
        .andRecalculateOn(api.dashboardWideEvent(Const.EVENT_NAME_SELECT_CUSTOMER))
        // pass the Event attribute value as parameter to the embedded dashboard
        .withEventDataAttr(Const.EVENT_ATTRIBUTE_CUSTOMER_ID).asParam(EMBEDDED_DASHBOARD_INPUT_FIELD_CUSTOMER_ID)
