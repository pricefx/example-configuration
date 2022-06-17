import net.pricefx.common.api.CalculationResultType
import net.pricefx.common.api.InputType

if (quoteProcessor.isPrePhase()) {

    def input1 = api.inputBuilderFactory()
            .createOptionEntry("myCustomHeaderInput1")
            .setOptions(["one", "two", "three"])
            .setParameterGroup("__UI_DetailPageHeaderInputs")  // this will position it to custom header
            .buildMap()

    quoteProcessor.addOrUpdateInput(input1)

}


if (quoteProcessor.isPostPhase()) {
    quoteProcessor.addOrUpdateOutput([
            "resultName": "__UI_DetailPageHeader",
            "resultType": CalculationResultType.SIMPLE.toString(),
            "result"    : [
                    [ // column with standard fields
                      fields: [

                              "createdByName",
                              "quoteStatus",
                              "creationWorkflow",
                              "workflowStatus"
                      ]
                    ],
                    [ // another column with standard fields
                      fields: [
                              "effectiveDate",
                              "expiryDate",
                              "lastUpdateDate"
                      ],
                    ],
//                    [ // column with some quote attributes
//                      fields: [
//
//                              ["name": "customerId", "label": "My Customer Id"], //specified Quote attribute, type is optional
//                              ["name": "uniqueName", "label": "My Unique Id", "type": "string"], //specified Quote attribute, type is optional
//                      ],
//                    ],
                    [ //column with custom header inputs
                      inputs: [
                              [
                                      "name": "myCustomHeaderInput1"
                              ]
                      ],

                    ],
                    [ // column with highchart
                      chart: [
                              resultName: "MyChart",
//                              resultLabel: "My Chart",
                              resultType: "HIGHCHART",
                              result    : createResultHighchart()
                      ],
                      //width          : 200, // initial width in pixels (number) or CSS width (string)
                      //height: 250, // chart height in pixels, default is 200
                      //backgroundColor: 'yellow' // optional
//         'min-width': 200, // optional and of the same type as width
//         'max-width': 400, // optional and of the same type as width
//     flex: '1 1 auto' // optional, see CSS flex
                    ],
//                [ // column with chart
//                  chart : createChart(),
////         backgroundColor: 'rgba(0,0,0,0)', // transparent color by default
//                  width : 250,
//                  height: 250,
//                ],
            ]
    ])

}

return


def createResultHighchart() {

    def seriesData = [
            [
                    name: 'Series1',
                    data: [1, 2, 3] //list of yAxis values, or list of maps with y value
            ], [
                    name: 'Series2',
                    data: [[y: 1], [y: 2], [y: 3]]
            ]
    ]

    def categoryData = ['x1', 'x2', 'x3'] //list of xAxis values

    def definition = [
            chart      : [
                    type: 'column'
            ],
            title      : [
                    text: 'Title'
            ],
            subtitle   : [
                    text: 'Subtitle'
            ],
            xAxis      : [
                    categories: categoryData,
                    title     : [
                            text: 'X-axis Title'
                    ]
            ],
            yAxis      : [
                    title: [
                            text: 'Y-axis Title'
                    ]
            ],
            tooltip    : [
                    headerFormat: '{point.x}',
                    pointFormat : '{series.name}: <b>{point.y}</b>'
            ],
            plotOptions: [
                    column: [
                            dataLabels: [
                                    enabled: true
                            ]
                    ]
            ],
            credits    : [
                    enabled: false
            ],
            series     : seriesData
    ]

    return api.buildHighchart(definition)


//    api.buildFlexChart([
//            chart  : [
//                    type: "column"
//            ],
//            title  : [
//                    text: "Monthly Volume and AVG NetPrice PU in last 6 months"
//            ],
//            xAxis  : [
//                    title     : [
//                            text: 'Date'
//                    ],
//                    categories: ["1", "2", "3", "4"],
//            ],
//            yAxis  : [
//                    [
//                            title : [
//                                    text: 'Average Net Price per Unit'
//                            ],
//                            labels: [
//                                    format: '{value} BRL'
//                            ],
//                    ],
//                    [
//                            title   : [
//                                    text: 'Total Volume'
//                            ],
//                            opposite: true
//                    ],
//            ],
//            series : [
//                    [
//                            name : "Total Volume",
//                            type : 'column',
//                            yAxis: 1,
//                            data : [4.0, 3.9, 6.5, 9.1]
//                    ],
//                    [
//                            name   : "Average Net Price per Unit",
//                            type   : 'spline',
//                            data   : [70.0, 60.9, 90.5, 100.1],
//                            tooltip: [
//                                    valueSuffix: ' BRL'
//                            ]
//                    ]
//            ],
//            legend : [enabled: true],
//            credits: [enabled: false]
//    ])
}
