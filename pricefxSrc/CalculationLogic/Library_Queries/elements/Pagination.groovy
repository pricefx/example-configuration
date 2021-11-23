import com.googlecode.genericdao.search.Filter
import groovy.transform.Field

@Field final Integer MAX_ROWS = 10

void forEach(String typeCode, Filter filter, Closure callback) {
    int startRow = 0
    List results
    while(results = api.find(typeCode, startRow, MAX_ROWS, null, null, filter)){
        startRow += results.size()
        results.forEach(callback)
    }
}