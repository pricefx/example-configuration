def chartDefinition = [

        chart: [
                type: 'column'
        ],

        title: [
                text: 'Total fruit consumption, grouped by gender'
        ],

        xAxis: [
                categories: ['Apples', 'Oranges', 'Pears', 'Grapes', 'Bananas']
        ],

        yAxis: [
                allowDecimals: false,
                min: 0,
                title: [
                        text: 'Number of fruits'
                ]
        ],

        tooltip: [
                headerFormat: '<b>{point.key}</b><br/>',
                pointFormat: '{series.name}: {point.y} <br/>',
                footerFormat: 'Total: {point.total}',
                useHTML: true
        ],

        plotOptions: [
                column: [
                        stacking: 'normal'
                ]
        ],

        series: [[
                         name: 'John',
                         data: [5, 3, 4, 7, 2],
                         stack: 'male'
                 ], [
                         name: 'Joe',
                         data: [3, 4, 4, 2, 5],
                         stack: 'male'
                 ], [
                         name: 'Jane',
                         data: [2, 5, 6, 2, 1],
                         stack: 'female'
                 ], [
                         name: 'Janet',
                         data: [3, 0, 4, 4, 3],
                         stack: 'female'
                 ]]
]

api.buildHighchart(chartDefinition)
