def pgId = out.CurrentItem?.id
//if (!pgId) return

def element2fieldName = api.find("PGIM", Filter.equal("priceGridId", pgId))
        ?.findAll { it.elementName != null }
        ?.collectEntries { [(it.elementName): it.fieldName] }

def fieldListPrice = element2fieldName["ListPrice"]
def fieldCost = element2fieldName["Cost"]
def fieldGrossMargin = element2fieldName["GrossMargin"]


def sumListPrice = 0.0, sumCost = 0.0, sumGrossMargin = 0.0

def filters = [
        Filter.equal("priceGridId", pgId)
]

def startRow = 0
def maxRows = api.getMaxFindResultsLimit()

while (rows = api.find("PGI", startRow, maxRows, "sku", [fieldListPrice, fieldCost, fieldGrossMargin], *filters)) {
    rows.each { pgi ->
        if (pgi[fieldListPrice] != null && pgi[fieldCost] != null && pgi[fieldGrossMargin] != null) {
            sumListPrice += pgi[fieldListPrice] as BigDecimal
            sumCost += pgi[fieldCost] as BigDecimal
            sumGrossMargin += pgi[fieldGrossMargin] as BigDecimal
        }
    }
    startRow += rows.size()
}

def sums = [
        sumListPrice  : sumListPrice,
        sumCost       : sumCost,
        sumGrossMargin: sumGrossMargin,
]

api.logInfo("PricelistHeader", "sums: ${sums}")
return sums