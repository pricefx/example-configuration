//added to STUB

if (api.isSyntaxCheck()) {

    //insert the reference to the Configurator
    api.configurator(Constants.CONFIGURATOR_INPUT_NAME, Constants.CONFIGURATOR_LOGIC_NAME)

    //Set the label of the button, which will open the Configurator
    api.getParameter(Constants.CONFIGURATOR_INPUT_NAME)?.setLabel("Configure the Delivery")
}