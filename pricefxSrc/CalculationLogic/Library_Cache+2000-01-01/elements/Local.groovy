public <T> T getAt(String key, Closure<T> getInitValue){
    if(!api.local[key]){
        api.local[key] = getInitValue()
    }
    return api.local[key] as T
}