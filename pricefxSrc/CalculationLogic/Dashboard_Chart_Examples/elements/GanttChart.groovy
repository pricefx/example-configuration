def gantt = libs.Library_Charts.Gantt

def data = [
        [
                start   : '2022-11-1',
                end     : '2022-11-2',
                y       : 0,
                assignee: 'Johannes'
        ], [
                start     : '2022-11-2',
                end       : '2022-11-5',
                y         : 1,
                assignee  : 'Gustaf',
        ], [
                start   : '2022-11-8',
                end     : '2022-11-9',
                y       : 2,
                assignee: 'Karl-Oskar'
        ], [
                start   : '2022-11-9',
                end     : '2022-11-19',
                y       : 1,
                assignee: 'Johannes'
        ], [
                start     : '2022-11-10',
                end       : '2022-11-23',
                y         : 2,
                assignee  : 'Karl-Oskar',
        ]
].collect { dataPoint ->
    dataPoint + [
            start: api.parseDate('yyyy-MM-dd', dataPoint.start as String),
            end:   api.parseDate('yyyy-MM-dd', dataPoint.end as String),
    ]
}

def yLabels = ['Prototyping', 'Development', 'Testing']

gantt.buildGanttChart('Project Planning', yLabels, data)