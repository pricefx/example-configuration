import net.pricefx.server.dto.calculation.ResultHighchart

def gauges = libs.Library_Charts.Gauge

String productGroup = Utils.currentProductGroup
def yellowThreshold = Utils.getYellowThreshold(productGroup) as BigDecimal ?: 0.0
def redThreshold = Utils.getRedThreshold(productGroup) as BigDecimal ?: 0.0
def criticalThreshold = Utils.getCriticalThreshold(productGroup) as BigDecimal ?: 0.0

def pocketMarginPct = (out.PocketMarginPct ?: 0)

return gauges.arcGaugeAlert(
        'Title',
        '%',
        pocketMarginPct * 100,
        criticalThreshold * 100,
        redThreshold * 100,
        yellowThreshold * 100
)
