def controller = api.newController()

controller.addHTML("<h2>Download XLS report</h2>")


def pg = api.find("PG", 0, 1, null)?.find()

def payload = api.jsonEncode(
        [
                pgId: pg?.id
        ]
)

controller.addDownloadButton("Download XLS of LPG '${pg.label}'",
        "/formulamanager.executeformula/Export_Pricelist?output=xls",
        payload)

return controller