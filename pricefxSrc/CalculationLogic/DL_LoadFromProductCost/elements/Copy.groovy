def target = api.getDatamartRowSet("target")

def filters = [
        Filter.equal("name", "ProductCost")
]

def pxIterator = api.stream("PX", "sku", *filters)

def newRow
pxIterator.each { row ->

    newRow = [
            "ProductId": row.sku,
            "AvgCost"  : row.attribute1
    ]

    target?.addRow(newRow)

    api.trace(row.sku, row.attribute1) // TODO: only for testing
}

pxIterator?.close()
