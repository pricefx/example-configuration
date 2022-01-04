def gauges = libs.Library_Charts.Gauge
def colors = libs.Library_CSS.Color

String title = 'Speedometer'
String unit = '%'
BigDecimal gaugeValue = input.userInput?.gaugeValue ?: 0
BigDecimal criticalUpperBound = 0.2
BigDecimal redUpperBound = 0.4
BigDecimal yellowUpperBound = 0.6

return gauges.speedometer(
        title,
        unit,
        gaugeValue * 100,
        criticalUpperBound * 100,
        redUpperBound * 100,
        yellowUpperBound * 100
)