final String EMPTY_BUSINESS_UNIT = "No Name BU"
final String EMPTY_PRODUCT_GROUP = "No Name PG"

def data =
        out.Data
                .collect { row ->
                    //this 'collect' is only to replace the empty strings, which makes it easier to test
                    [
                            BusinessUnit: row.BusinessUnit ?: EMPTY_BUSINESS_UNIT,
                            ProductGroup: row.ProductGroup ?: EMPTY_PRODUCT_GROUP,
                            Revenue     : row.Revenue
                    ]
                }
                .groupBy { row -> //group by the Business Unit, to get a different data structure
                    row.BusinessUnit
                }

def seriesData = data.collect {
    [
            name     : it.key,
            y        : it.value.sum { it.Revenue },
            drilldown: it.key,
    ]
}




def drilldownSeriesData = data.collect {
    [
            name: it.key, //BusinessUnit
            id  : it.key,
            data: it.value.collect { row ->
                [
                        row.ProductGroup,
                        row.Revenue
                ]
            }
    ]

}

def definition = [
        chart      : [
                type: 'column'
        ],
        title      : [
                text: 'Revenue per Business Unit and Product Group'
        ],
        subtitle   : [
                text: 'Click on the column to drill-down'
        ],
        xAxis      : [
                type: 'category'
        ],
        yAxis      : [
                title: [
                        text: 'Revenue'
                ]

        ],
        legend     : [
                enabled: false
        ],
        plotOptions: [
                series: [
                        borderWidth: 0,
                        dataLabels : [
                                enabled: true,
                                format : '{point.y:,.0f} ' + out.Currency
                        ]
                ]
        ],

        tooltip    : [
                headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                pointFormat : '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:,.0f} ' + out.Currency + '</b><br/>'
        ],

        series     : [
                [
                        name        : "Business Units",
                        colorByPoint: true,
                        data        : seriesData
                ]
        ],
        drilldown  : [
                series: drilldownSeriesData
        ]
]

return api.buildHighchart(definition)