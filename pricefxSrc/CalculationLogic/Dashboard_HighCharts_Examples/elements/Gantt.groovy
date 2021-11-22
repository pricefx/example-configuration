def data = [
        [
                start   : '2018-11-1',
                end     : '2018-11-2',
                y       : 0,
                assignee: 'Johannes'
        ], [
                start     : '2018-11-2',
                end       : '2018-11-5',
                y         : 1,
                assignee  : 'Gustaf',
        ], [
                start   : '2018-11-8',
                end     : '2018-11-9',
                y       : 2,
                assignee: 'Karl-Oskar'
        ], [
                start   : '2018-11-9',
                end     : '2018-11-19',
                y       : 1,
                assignee: 'Johannes'
        ], [
                start     : '2018-11-10',
                end       : '2018-11-23',
                y         : 2,
                assignee  : 'Karl-Oskar',
        ]
].collect { entry ->
    entry + [
            start: api.parseDate('yyyy-MM-dd', entry.start as String),
            end:   api.parseDate('yyyy-MM-dd', entry.end as String),
    ]
}

def yLabels = ['Prototyping', 'Development', 'Testing']

def gantt = libs.Library_Charts.Gantt

gantt.buildGanttChart('Project Planning', yLabels, data)