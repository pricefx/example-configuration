def priceGridId = Lib.getPriceGridId()

def data = [//data sequence should follow that of the waterfall elements
            [
                    name : 'List Price',
                    y    : out.Summary.sumListPrice,
                    color: '#4573a7'
            ],
            [
                    name: 'Cost',
                    y   : -out.Summary.sumCost,
            ],
            [
                    name : 'Gross Margin',
                    y    : out.Summary.sumGrossMargin,
                    isSum: true, //this will add up previous Y-axis values since the last intermediate sum, or since the start of the series. y value will be ignored
                    color: '#4573a7' //blue - explicitly specify the color, otherwise series.color will be used
            ],
]

def definition = [
        chart   : [
                type: 'waterfall'
        ],

        title   : [
                text: 'Waterfall'
        ],

        subtitle: [
                text: ''
        ],

        xAxis   : [
                type: 'category' //when type is 'category', series.data.name will become X-axis value
        ],

        yAxis   : [
                title: [
                        enabled: false
                ]
        ],

        legend  : [
                enabled: false
        ],

        tooltip : [
                pointFormat: '<b>{point.y:,.2f}</b> EUR'
        ],

        series  : [
                [
                        upColor     : '#89a54e', //green - this is color of the positive elements
                        color       : '#aa4643', //red - this is color of all elements, unless explicitly specified
                        data        : data,
                        dataLabels  : [
                                enabled: true,
                                format : '{point.y:,.2f} EUR',
                                style  : [
                                        fontWeight: 'bold'
                                ]
                        ],
                        pointPadding: 0
                ]
        ],
        credits : [
                enabled: false
        ]
]

api.setPricegridCalculationChart(definition, priceGridId)




