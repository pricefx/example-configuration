import net.pricefx.common.api.chart.SeriesType
import net.pricefx.server.dto.calculation.ResultHighchart

/**
 * @param title
 * @param categories
 * @param series Array of maps with two properties: name (String) & data (List<String). Example: [[name: 'US', data: [1,2,3]]]
 * @return
 */
ResultHighchart verticalBars(
        String title,
        List<String> categories,
        List<Map<String, Object>> series
) {
    return api.buildHighchart([
            chart: [
                    type: 'bar',
            ],
            title: [
                    text: title,
            ],
            xAxis: [
                    categories: categories,
            ],
            yAxis: [
                    min: 0,
                    title: title
            ],
            series: series
    ])
}

/**
 * Same as verticalBars, except that the bars are placed horizontally
 * @param title
 * @param categories
 * @param series
 * @return
 */
ResultHighchart horizontalBars(
        String title,
        List<String> categories,
        List<Map<String, Object>> series
) {
    return api.buildHighchart([
            chart: [
                    type: 'column',
            ],
            title: [
                    text: title,
            ],
            xAxis: [
                    categories: categories,
            ],
            yAxis: [
                    min: 0,
                    title: title
            ],
            series: series
    ])
}