def typedIds = input.selectedQuotes.collect { it.typedId as String }
typedIds.each { typedId ->
    submitQuote(typedId)
}

void submitQuote(String typedId){
    post("clicmanager.runjob/$typedId/submit")
}

def post(String relativeUrl, def payload = null){
    def body = payload ? api.jsonEncode(payload) as String : ''
    api.boundCall(
            'thisPartition',
            relativeUrl,
            body,
    )
}
//
//String getUrlWithoutLeadingForwardSlash(String url){
//    def pattern = /\\/?(.*)/
//    def match = url =~ pattern
//    return match?.getAt(0)?.getAt(0)
//}