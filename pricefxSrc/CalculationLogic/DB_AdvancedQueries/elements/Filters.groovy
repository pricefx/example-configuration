if (api.isInputGenerationExecution()) {

    def dmCtx = api.getDatamartContext()
    def dm = dmCtx.getDatamart("Transaction")

    dmCtx.dimFilterEntry("CountryCode", dm.getColumn("CountryCode"), "DE")
    api.getParameter("CountryCode").setLabel("Filter by Country Code")

    dmCtx.dimFilterEntry("ProductId", dm.getColumn("ProductId"), "MB-0001")
    api.getParameter("ProductId").setLabel("Filter by Product Id")
}