if (cProcessor.isPrePhase()) {
    cProcessor.setRenderInfo("userGroupEdit", "hide", true)
    cProcessor.setRenderInfo('contractExternalRef', 'hide', true)
    cProcessor.addOrUpdateInput([
            "name": "ProductGroup",
            "type": InputType.HIDDEN
    ])
    cProcessor.addOrUpdateInput([
            "name": "CustomerGroup",
            "type": InputType.HIDDEN
    ])
}
