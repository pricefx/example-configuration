if (api.isDebugMode() && api.isInputGenerationExecution()) {

    api.inputBuilderFactory().createOptionEntry(Const.INPUT_NAME_SHIP_TO)
            .setOptions(out.Countries)
            .getInput()

    api.inputBuilderFactory().createOptionEntry(Const.INPUT_NAME_DELIVERY_TYPE)
            .setOptions(out.DeliveryTypes)
            .getInput()

    api.inputBuilderFactory().createUserEntry(Const.INPUT_NAME_EXTRA_SURCHARGE)
            .getInput()

}
