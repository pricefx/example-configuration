import net.pricefx.server.dto.calculation.ResultHighchart

/**
 * @param title - Title of the chart
 * @param yLabels - An array of strings that translates Y values into labels on the Y axis.
 * @param data - list of maps with three required key-value pairs, and any other optional key-value pairs. Formatted as [[ start: Date, end: Date, y: Integer, ... ]]
 * @return a high chart.
 */
ResultHighchart buildGanttChart(
        String title,
        List<String> yLabels,
        List<Map<String, Object>> data
) {
    def formats = libs.Library_Charts.Formats

    // Transform the dates into Unix Epoch, which is required by Highcharts.
    def seriesData = data.collect { entry ->
        entry + [
                start: (entry.start as Date).getTime(),
                end  : (entry.end as Date).getTime(),
        ]
    }

    def chartDefinition = [
            chart  : [
                    type: 'gantt',
            ],
            credits: [
                    enabled: false, // Hide the Highcharts link
            ],
            legend : [
                    enabled: false, // Let the legend be hidden.
            ],
            title  : [
                    text: title,
            ],
            yAxis  : [
                    categories: yLabels,
            ],
            tooltip: [
                    outside    : true,
                    pointFormat: getToolTipPointFormat(seriesData),
            ],
            xAxis  : [
                    type  : 'datetime',
                    labels: [
                            format: "{value:$formats.MONTH_FORMAT}",
                    ],
            ],
            series : [[
                              data: seriesData,
                      ]],
    ]

    def chart = api.buildHighchart(chartDefinition)
    chart.addModule('gantt')

    return chart
}

/**
 * Returns a value that can be passed to a highchart definition objects tooltip.pointFormat property,
 * to display all properties that are passed in the series data.
 * @param data
 * @return A String that can be passed to tooltip.pointFormat
 */
String getToolTipPointFormat(List<Map<String, Object>> data) {
    def formats = libs.Library_Charts.Formats
    // Data can contain other properties other than start, end, and y. Gather these keys in a list, and tell high charts
    // that these property values should be displayed on the tooltips.
    def knownPropertyKeys = ['start', 'end', 'y']
    def allPropertyKeys = data.collect { dataPoint ->
        dataPoint.keySet().toList()
    }.flatten().unique()
    def otherPropertyKeys = allPropertyKeys - knownPropertyKeys
    return (
            [
                    "Start: {point.start:$formats.DAY_FORMAT}",
                    "End: {point.end:$formats.DAY_FORMAT}",
            ] + otherPropertyKeys.collect { propKey -> "$propKey: {point.$propKey}" }
    ).join('<br/>')
}