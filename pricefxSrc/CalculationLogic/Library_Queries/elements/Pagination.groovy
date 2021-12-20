import com.googlecode.genericdao.search.Filter
import groovy.transform.Field

@Field final Integer MAX_ROWS = 200

void forEach(String typeCode, Filter filter, Closure callback) {
    int startRow = 0
    List results
    while(true){
        results = api.find(typeCode, startRow, MAX_ROWS, null, null, filter)
        results.forEach(callback)
        if(results.size() < MAX_ROWS){
            break
        }
        startRow += results.size()
    }
}