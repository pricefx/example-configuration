// Imports
def priceGridItem = libs.PriceListLib.PriceGridItem

def priceGridId = Lib.getPriceGridId()

Map<String, String> element2fieldName = api.find("PGIM", Filter.equal("priceGridId", priceGridId))
        ?.findAll { it.elementName != null }
        ?.collectEntries { [(it.elementName): it.fieldName] }

def fieldListPrice = element2fieldName["ListPrice"]
def fieldCost = element2fieldName["Cost"]
def fieldGrossMargin = element2fieldName["GrossMargin"]
def fields = [fieldListPrice, fieldCost, fieldGrossMargin]

BigDecimal sumListPrice = 0.0
BigDecimal sumCost = 0.0
BigDecimal sumGrossMargin = 0.0

priceGridItem.forEach(priceGridId, fields) { it ->
    sumListPrice += it[fieldListPrice] as BigDecimal ?: 0
    sumCost += it[fieldCost] as BigDecimal ?: 0
    sumGrossMargin += it[fieldGrossMargin] as BigDecimal ?: 0
}

def sums = [
        sumListPrice  : sumListPrice,
        sumCost       : sumCost,
        sumGrossMargin: sumGrossMargin,
]

api.logInfo("PricelistHeader", "sums: ${sums}")
return sums
