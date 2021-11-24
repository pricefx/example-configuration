def pieCharts = libs.Library_Charts.Pie
String title = 'Sales by Country'
String seriesName = 'Sales'
String unit = 'EUR'
def data = [
        [
                name: 'Sweden',
                y   : 24.41e3,
        ], [
                name: 'Finland',
                y   : 11.84e3
        ], [
                name: 'Norway',
                y   : 10.85e3
        ], [
                name: 'Czech Republic',
                y   : 4.67e3
        ], [
                name: 'Other',
                y   : 4.18e3
        ]
]
pieCharts.semiCircle(title, seriesName, unit, data)