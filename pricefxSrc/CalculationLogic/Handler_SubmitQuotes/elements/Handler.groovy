// Expects the input to have a property 'quotes'
// that is a list of maps with one property 'typedId'
def typedIds = input.quotes.collect { it.typedId as String }

typedIds.each { typedId ->
    submitQuote(typedId)
}

return

void submitQuote(String typedId){
    api.boundCall(
            'thisPartition',
            "clicmanager.runjob/$typedId/submit",
            '',
    )
}
