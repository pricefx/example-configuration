def gauges = libs.Library_Charts.Gauge

String title = 'Arc Gauge 180° Gradient'
String unit = '%'
BigDecimal gaugeValue = input.userInput?.gaugeValue ?: 0
BigDecimal minValue = -1
BigDecimal maxValue = 1
BigDecimal errorThreshold = -0.5
BigDecimal warningThreshold = 0
BigDecimal successThreshold = 0.5

return gauges.arcGauge180Gradient(
        title,
        unit,
        gaugeValue * 100,
        minValue * 100,
        maxValue * 100,
        errorThreshold * 100,
        warningThreshold * 100,
        successThreshold * 100
)