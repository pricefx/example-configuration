def gauges = libs.Library_Charts.Gauge
def colors = libs.Library_CSS.Color


String title = 'Arc Gauge 360°'
String unit = '%'
BigDecimal gaugeValue = input.userInput?.gaugeValue ?: 0
BigDecimal minValue = 0
BigDecimal maxValue = 1

return gauges.arcGauge360(
        title,
        unit,
        gaugeValue * 100,
        minValue * 100,
        maxValue * 100,
        colors.INFO
)