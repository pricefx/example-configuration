import groovy.transform.Field

@Field final String RESULT_CACHE_KEY = 'result'

void putAt(String element, Object value){
    add(element, value)
}

void add(String element, Object value){
    initResultIfAbsent(element)
    api.trace('element', element)
    api.trace('value', value)
    results[element].value = value
}

void addError(String element, String message){
    initResultIfAbsent(element)
    results[element].error = message
}

void initResultIfAbsent(String element){
    if(!results[element]){
        results[element] = [:] as Map<String, Object>
    }
}

Map<String, Map<String, Object>> getResults(){
    def cache = libs.Library_Cache.Local
    return cache.getAt(RESULT_CACHE_KEY, {[:] as Map<String, Map<String, Object>>})
}

Object outputResult(String element){
    def resultEntry = results[element]
    if(resultEntry && resultEntry.error){
        api.criticalAlert(resultEntry.error as String)
        api.addWarning(resultEntry.error as String)
    }
    return resultEntry?.value
}
