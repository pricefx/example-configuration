import net.pricefx.common.api.chart.SeriesType

return getTotalSalesByDimension(input.Year, 'ProductGroup')

def getTotalSalesByDimension(String year, String dimension) {
    final table = 'DM.Transaction'
    return api.newChartBuilder()
            .newBarLine()
            .getOptions()
            .setTitle("Sales by $dimension")
            .setBoxplotAxisLabel('Box Plot')
            .back()
            .addSeries()
            .setDatamart(table)
            .setCurrency('EUR')
            .setHideDataLabels(true)
            .setAxisX(dimension)
            .setAxisY('InvoicePrice')
            .withTotal()
            .back()
            .setType(SeriesType.BAR)
            .addDimFilter('InvoiceDateYear', year)
            .setGeneratedQueryDto('{"name":null,"datamart":"DM.Transaction","label":"Bar Data","limit":null,"source":"DM.Transaction","projections":{"x":"ProductGroup","y":{"advancedProjection":true,"expression":"SUM({field})","function":null,"parameters":{"field":"InvoicePrice","quantity":"Quantity","base":"ListPrice"},"default":null,"formatString":"∑{field}","label":"∑Invoice Price","name":"InvoicePrice","alias":"y"}},"options":{"currency":"EUR","distribution":["y"]},"filter":{},"dimensionFilters":[{"fieldName":"InvoiceDateYear","fieldValue":["2020"],"fieldSynced":false}],"rollup":true,"sortBy":["x"]}')
            .back()
            .getDictionary()
            .buildFromOpaqueString('[{"sectionIdx":1,"category":"PROJECTION","categoryLabel":"Projection","defaultValue":"Product Group","field":{"name":"ProductGroup","label":"Product Group","rank":15,"visibility":1,"sourceField":"ProductGroup","expression":"ProductGroup","system":false,"numeric":false,"key":false,"auxiliary":false,"persisted":true,"partitioningKey":false,"queryable":true,"time":false,"deployed":true,"dimension":true,"calculated":false,"aggregation":false,"deleted":false,"type":"TEXT","source":"DMDS.Product","owningFC":"Product"},"key":"x","keyLabel":"Axis X","sectionLabel":"Bar Data"},{"sectionIdx":1,"category":"PROJECTION","categoryLabel":"Projection","defaultValue":"∑Invoice Price","field":{"name":"InvoicePrice","label":"Invoice Price","rank":9,"visibility":1,"expression":"ListPrice - Discount","system":false,"numeric":true,"key":false,"auxiliary":false,"persisted":false,"partitioningKey":false,"queryable":true,"time":false,"deployed":false,"dimension":false,"calculated":true,"aggregation":false,"deleted":false,"type":"MONEY"},"key":"y","keyLabel":"Axis Y","sectionLabel":"Bar Data"}]')
            .back()
            .build()
}

