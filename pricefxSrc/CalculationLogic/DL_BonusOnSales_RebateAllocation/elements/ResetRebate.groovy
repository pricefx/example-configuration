if (api.isInputGenerationExecution()) {
    return
}

def source = api.getDatamartRowSet('source')
def target = api.getDatamartRowSet('target')

while (source.next()) {
    def row = source.currentRow
    row.Rebate = 0.0
    source.updateRow(row)
    target.addRow(row)
}