def data = [
        [
                start   : '2018-11-1',
                end     : '2018-11-2',
                y       : 0,
                assignee: 'JonArild'
        ], [
                start     : '2018-11-2',
                end       : '2018-11-5',
                y         : 1,
                assignee  : 'Oystein',
        ], [
                start   : '2018-11-8',
                end     : '2018-11-9',
                y       : 2,
                assignee: 'Torstein'
        ], [
                start   : '2018-11-9',
                end     : '2018-11-19',
                y       : 1,
                assignee: 'JonArild'
        ], [
                start     : '2018-11-10',
                end       : '2018-11-23',
                y         : 2,
                assignee  : 'Torstein',
        ]
].collect { entry ->
    def newEntry = entry.clone()
    newEntry.start = api.parseDate('yyyy-MM-dd', entry.start).getTime()
    newEntry.end = api.parseDate('yyyy-MM-dd', entry.end).getTime()
    return newEntry
}

def chartDefinition = [
        chart: [
                type: 'gantt'
        ],
        title  : [
                text: 'Highcharts Gantt Chart'
        ],

        yAxis  : [
                categories: ['Prototyping', 'Development', 'Testing']
        ],

        tooltip: [
                outside: true
        ],
        xAxis: [
            type: 'datetime',
            labels: [
                format: '{value:%b-%e}'
            ],
        ],
        series : [[
                          name      : 'Project 1',
                          data      : data,
                          dataLabels: [[
                                               enabled: true,
                                               useHTML: true,
                                               align  : 'left'
                                       ], [
                                               enabled: true,
                                               useHTML: true,
                                               align  : 'right'
                                       ]]
                  ]]
]

api.buildHighchart(chartDefinition).addModule('gantt')
