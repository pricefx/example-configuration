def chart = api.newChartBuilder()
        .newTimeSeries()
        .getOptions()
        .setTitle('Revenue and Margin % in Time')
        .setSubtitle(input.CustomerId ? "Filter by customer ${input.CustomerId}" : null)
        .setComparison(false)
        .setHideLegend(false)
        .setHideTooltips(false)
        .setDisableDrilldown(false)
        .setDisableZoom(false)
        .setXLabel('Quarter')
        .setYLabel('Revenue')
        .setShowZAxis(true)
        .setZLabel('Margin %')
        .setLegacyComparisonMode(false)
        .setBoxplotAxisLabel('Box Plot')
        .back()
        .addSeries()
        .setLabel('Transactions')
        .setDatamart('DM.Transaction')
        .setCurrency('EUR')
        .setHideDataLabels(true)
        .setAxisX('InvoiceDateQuarter')
        .setAxisY('InvoicePrice').withTotal().back()
        .setType(SeriesType.BAR)
        .setShowBoxplot(false)
        .addDimFilter('InvoiceDateYear', input.Year)
        .addDimFilter('CustomerId', input.CustomerId)
        .addAdditionalMeasure()
        .setMeasure('Margin')
        .setId(1)
        .withPercent()
        .withBoxplotField()
        .setType(SeriesType.LINE)
        .setOnZAxis(true)
        .back()
        .setGeneratedQueryDto('{"name":null,"datamart":"DM.Transaction","label":"Transactions","limit":null,"source":"DM.Transaction","projections":{"x":"InvoiceDateQuarter","y":{"advancedProjection":true,"expression":"SUM({field})","function":null,"parameters":{"field":"InvoicePrice","quantity":"Quantity","base":"ListPrice"},"default":null,"formatString":"∑{field}","label":"∑Invoice Price","name":"InvoicePrice","alias":"y"},"m1":{"advancedProjection":true,"expression":"100*SUM({field})/SUM({base})","function":null,"parameters":{"field":"Margin","quantity":"Quantity","base":"ListPrice"},"default":null,"formatString":"∑{field}/ƒ{base} (%)","label":"∑Margin/ƒListPrice (%)","name":"Margin","alias":"m1","onZAxis":true,"seriesType":"LINE","id":1}},"options":{"currency":"EUR","regression":["y","x"]},"filter":{},"dimensionFilters":[{"fieldName":"InvoiceDateYear","fieldValue":"2020"},{"fieldName":"CustomerId","fieldValue":"CD-00004"}],"rollup":true,"sortBy":["x"]}')
        .back()

        .getDictionary()
        .buildFromOpaqueString('[{"sectionIdx":1,"category":"PROJECTION","categoryLabel":"Projection","defaultValue":"Invoice Date Quarter","field":{"name":"InvoiceDateQuarter","label":"Invoice Date Quarter","rank":39,"functionalType":"TIMEDIMENSION","sourceField":"CalQuarter","expression":"InvoiceDateQuarter","system":true,"numeric":false,"key":false,"persisted":true,"dimension":true,"calculated":false,"queryable":true,"time":true,"auxiliary":false,"deployed":true,"aggregation":false,"deleted":false,"type":"TEXT","source":"DMDS.cal","owningFC":"[System]"},"key":"x","keyLabel":"Axis X","sectionLabel":"Transactions","value":"Quarter"},{"sectionIdx":1,"category":"PROJECTION","categoryLabel":"Projection","defaultValue":"∑Invoice Price","field":{"name":"InvoicePrice","label":"Invoice Price","rank":9,"expression":"ListPrice - Discount","system":false,"numeric":true,"key":false,"persisted":false,"dimension":false,"calculated":true,"queryable":true,"time":false,"auxiliary":false,"deployed":false,"aggregation":false,"deleted":false,"type":"MONEY"},"key":"y","keyLabel":"Axis Y","sectionLabel":"Transactions","value":"Revenue"},{"sectionIdx":1,"category":"PROJECTION","categoryLabel":"Projection","defaultValue":"∑Margin/ƒ{base} (%)","field":{"name":"Margin","label":"Margin","rank":11,"expression":"InvoicePrice - Cost","system":false,"numeric":true,"key":false,"persisted":false,"dimension":false,"calculated":true,"queryable":true,"time":false,"auxiliary":false,"deployed":false,"aggregation":false,"deleted":false,"type":"MONEY"},"key":"m1","keyLabel":"Measure 1","sectionLabel":"Transactions","id":1,"value":"Margin %"}]')
        .back()
        .build()