import net.pricefx.server.dto.calculation.ResultGauge
import net.pricefx.server.dto.calculation.ResultHighchart

/**
 * Gauge that appears as an arc without indicators. The color of the arc changes gradually as the value increases.
 * The stops determine where the gradient starts/ends
 * @param title
 * @param unit
 * @param value
 * @param minValue
 * @param maxValue
 * @param errorStopValue
 * @param warningStopValue
 * @param successStopValue
 * @return
 */
ResultHighchart arcGauge180Gradient(
        String title,
        String unit,
        BigDecimal value,
        BigDecimal minValue,
        BigDecimal maxValue,
        BigDecimal errorStopValue,
        BigDecimal warningStopValue,
        BigDecimal successStopValue
) {
    def colors = libs.Library_CSS.Color

    def stops = [
            [transformStopValue(errorStopValue, minValue, maxValue), colors.ERROR],
            [transformStopValue(warningStopValue, minValue, maxValue), colors.WARNING],
            [transformStopValue(successStopValue, minValue, maxValue), colors.SUCCESS],
    ]

    def chart = api.buildHighchart([
            title: [
                    text: title
            ],
            chart      : [type: 'solidgauge'],
            credits    : [enabled: false],
            yAxis      : [
                    min              : minValue,
                    max              : maxValue,
                    stops            : stops,
                    // Only indicate max and min values, no intermediate values
                    tickPositions: [minValue, maxValue],
                    minorTickInterval: null,
                    lineWidth: 0,
                    tickWidth: 0,
                    labels           : [
                            y: 24,
                            format: "{value:.1f} $unit",
                    ],
            ],
            series     : [[
                                  name      : title,
                                  data      : [value],
                                  tooltip   : [valueSuffix: " $unit"],
                                  // The value label in the center
                                  dataLabels: [format: """<span style="font-size:24px">{y:.1f} $unit</span>"""],
                          ]],
            // Appearance
            pane       : [
                    center    : ['50%', '85%'],
                    size      : '140%',
                    startAngle: -90,
                    endAngle  : 90,
                    background: [
                            backgroundColor: colors.FAINT_GREY,
                            innerRadius    : '60%',
                            outerRadius    : '100%',
                            shape          : 'arc',
                            borderWidth: 0,
                    ]
            ],
            // Disable the border around the value label
            plotOptions: [solidgauge: [dataLabels: [borderWidth: 0]]],
    ])
    chart.addModule('solid-gauge')
    return chart
}

/**
 * Transforms the stop value to a number between 0 and 1.
 */
BigDecimal transformStopValue(BigDecimal threshold, BigDecimal minValue, BigDecimal maxValue) {
    return (threshold - minValue) / (maxValue - minValue)
}

ResultHighchart arcGauge360(
        String title,
        String unit,
        BigDecimal value,
        BigDecimal minValue,
        BigDecimal maxValue,
        String color
) {
    def chart = api.buildHighchart([
            title: [
                    text: title
            ],
            chart      : [type: 'solidgauge'],
            credits    : [enabled: false],
            yAxis      : [
                    min              : minValue,
                    max              : maxValue,
                    tickPositions: [],
                    lineWidth: 0,
            ],
            series     : [[
                                  name      : title,
                                  data      : [[
                                          y: value,
                                          color: color,
                                  ]],
                                  tooltip   : [valueSuffix: " $unit"],
                                  // The value label in the center
                                  dataLabels: [
                                          format: """<span style="font-size:24px">{y:.1f} $unit</span>"""
                                  ],
                          ]],
            // Appearance
            pane       : [
                    background: [
                            backgroundColor: 'rgba(0,0,0,0.06)',
                            innerRadius    : '60%',
                            outerRadius    : '100%',
                            shape          : 'arc',
                            borderWidth: 0,
                    ]
            ],
            // Disable the border around the centered value label
            plotOptions: [
                    solidgauge: [
                            dataLabels: [
                                    borderWidth: 0
                            ]
                    ]
            ],
    ])
    chart.addModule('solid-gauge')
    return chart
}

ResultHighchart arcGaugeAlert(
        String title,
        String unit,
        BigDecimal value,
        BigDecimal criticalUpperBound,
        BigDecimal redUpperBound,
        BigDecimal yellowUpperBound
) {
    def gauges = libs.Library_Charts.Gauge

    def minValue = criticalUpperBound
    def maxValue = yellowUpperBound + Math.abs(yellowUpperBound - criticalUpperBound) as BigDecimal

    def redStop = (minValue + redUpperBound) / 2
    def yellowStop = (yellowUpperBound + redUpperBound) / 2
    def greenStop = (maxValue + yellowUpperBound) / 2

    return gauges.arcGauge180Gradient(
            title,
            unit,
            value,
            minValue,
            maxValue,
            redStop,
            yellowStop,
            greenStop,
    )
}

ResultHighchart speedometer(
        String title,
        String unit,
        BigDecimal value,
        BigDecimal redLowerBound,
        BigDecimal redUpperBound,
        BigDecimal yellowUpperBound
){
    def colors = libs.Library_CSS.Color

    def minValue = redLowerBound
    def maxValue = yellowUpperBound + Math.abs(yellowUpperBound - redLowerBound) as BigDecimal

    def chart = api.buildHighchart([
        chart: [
            type: 'gauge',
            plotBackgroundColor: null,
            plotBackgroundImage: null,
            plotBorderWidth: 0,
            plotShadow: false
        ],
        credits    : [enabled: false],
        title: [
            text: title
        ],
        pane: [
            startAngle: -150,
            endAngle: 150,
            background: [[
                             backgroundColor: [
                                 linearGradient: [ x1: 0, y1: 0, x2: 0, y2: 1 ],
                                 stops: [
                                         [0, '#FFF'],
                                         [1, '#333']
                                 ]
                             ],
                             borderWidth: 0,
                             outerRadius: '109%'
                         ], [
                             backgroundColor: [
                                 linearGradient: [ x1: 0, y1: 0, x2: 0, y2: 1 ],
                                 stops: [
                                         [0, '#333'],
                                         [1, '#FFF']
                                 ]
                             ],
                             borderWidth: 1,
                             outerRadius: '107%'
                         ], [
                             // default background
                         ], [
                             backgroundColor: '#DDD',
                             borderWidth: 0,
                             outerRadius: '105%',
                             innerRadius: '103%'
                         ]]
        ],
        // the value axis
        yAxis: [
            min: minValue,
            max: maxValue,

            minorTickInterval: 'auto',
            minorTickWidth: 1,
            minorTickLength: 10,
            minorTickPosition: 'inside',
            minorTickColor: '#666',

            tickPixelInterval: 30,
            tickWidth: 2,
            tickPosition: 'inside',
            tickLength: 10,
            tickColor: '#666',
            labels: [
                step: 2,
                rotation: 'auto'
            ],
            title: [
                text: unit
            ],
            plotBands: [[
                            from: minValue,
                            to: redUpperBound,
                            color: colors.ERROR,
                        ], [
                            from: redUpperBound,
                            to: yellowUpperBound,
                            color: colors.WARNING
                        ], [
                            from: yellowUpperBound,
                            to: maxValue,
                            color: colors.SUCCESS
                        ]]
        ],
        series: [[
                     name: title,
                     data: [value],
                     dataLabels: [
                             format: """{y:.1f} $unit"""
                     ],
                     tooltip: [
                         valueSuffix: " $unit"
                     ]
                 ]]

    ])
    return chart
}

ResultGauge resultGaugeAlert(
        BigDecimal value,
        BigDecimal redLowerBound,
        BigDecimal redUpperBound,
        BigDecimal yellowUpperBound
) {
    def gauge = api.newGauge()

    def minValue = redLowerBound
    def maxValue = yellowUpperBound + Math.abs(yellowUpperBound - redLowerBound) as BigDecimal

    def red = 'rgba(223, 83, 83, 0.22)'
    def yellow = 'rgba(221, 223, 13, 0.22)'
    def green = 'rgba(85, 191, 59, 0.22)'

    gauge.min = minValue
    gauge.max = maxValue
    gauge.value = value
    gauge.addSector(redUpperBound, red)
    gauge.addSector(yellowUpperBound, yellow)
    gauge.addSector(null, green)

    return gauge
}