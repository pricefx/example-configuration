import com.googlecode.genericdao.search.Filter

def bar = libs.Library_Charts.Bar

def matchAll = Filter.isNotNull('TransactionId' )
def whereFilter = input.Year != null ? Filter.equal('InvoiceDateYear', input.Year) : matchAll

def dataSourceAPI = api.datamartContext

def table = dataSourceAPI.getDatamart('Transaction')
def query = dataSourceAPI.newQuery(table, true)
        .select('InvoiceDateQuarter', 'Quarter')
        .select('Region', 'Region')
        .select('SUM(InvoicePrice)', 'Sales')
        .orderBy('Quarter') // Speed up calls to .find()
        .where(whereFilter)

def result = dataSourceAPI.executeQuery(query)


def compareTime = {a, b -> a.Quarter <=> b.Quarter }

List<String> quarters = result.data.sort(compareTime).Quarter.unique()

api.trace(quarters)

List<Map<String, Object>> series = result.data.groupBy {it.Region}.collect { region, data ->
    [
            name: region,
            data: quarters.collect {quarter -> data.find {it.Quarter == quarter}?.Sales ?: 0.0},
    ]
}

String title = 'Sales per Quarter & Region'
return bar.verticalBars(title, quarters, series)