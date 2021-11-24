def bar = libs.Library_Charts.Bar

String title = 'Sales per Quarter & Region'
def categories = [
        '2019-Q1', '2019-Q2', '2019-Q3', '2019-Q4',
        '2020-Q1', '2020-Q2', '2020-Q3', '2020-Q4',
]
def series = [[
         name: 'EMEA',
         data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5]

 ], [
         name: 'APAC',
         data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3]

 ]]

return bar.verticalBars(title, categories, series)