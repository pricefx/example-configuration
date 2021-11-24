import net.pricefx.server.dto.calculation.ResultHighchart

/**
 * Data is a list of maps with two properties: y (Number) and name (String)
 * @param title
 * @param data
 * @return
 */
ResultHighchart pieChart(
        String title,
        String seriesName,
        String unit,
        List<Map<String, Object>> data
){
    return api.buildHighchart(  [
            chart: [
                    type: 'pie'
            ],
            title: [
                    text: title,
            ],
            credits    : [enabled: false],
            tooltip: [
                    pointFormat: "{series.name}: <b>{point.y:.0f} $unit</b> ({point.percentage:.1f}%)"
            ],
            accessibility: [
                    point: [
                            valueSuffix: '%'
                    ]
            ],
            plotOptions: [
                    pie: [
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: [
                                    enabled: true,
                                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                            ]
                    ]
            ],
            series: [[
                             name: seriesName,
                             colorByPoint: true,
                             data: data
                     ]]
    ])
}

ResultHighchart semiCircle(
        String title,
        String seriesName,
        String unit,
        List<Map<String, Object>> data
){
    return api.buildHighchart([
        chart: [
            plotBackgroundColor: null,
            plotBorderWidth: 0,
            plotShadow: false
        ],
        title: [
            text: title,
            align: 'center',
            verticalAlign: 'middle',
            y: 60
        ],
        credits    : [enabled: false],
        tooltip: [
            pointFormat: "{series.name}: <b>{point.y:.0f} $unit</b> {point.percentage:.1f}%"
        ],
        accessibility: [
            point: [
                valueSuffix: '%'
            ]
        ],
        plotOptions: [
            pie: [
                dataLabels: [
                    enabled: true,
                    distance: -50,
                    style: [
                        fontWeight: 'bold',
                        color: 'white'
                    ]
                ],
                startAngle: -90,
                endAngle: 90,
                center: ['50%', '75%'],
                size: '150%'
            ]
        ],
        series: [[
                     type: 'pie',
                     name: seriesName,
                     innerSize: '50%',
                     data: data
                 ]]
    ])
}