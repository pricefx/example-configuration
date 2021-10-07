if(!input.Customer){
    api.addWarning('Customer must be selected for the quote')
    return
}

String currency = api.customer("CustomerCurrency", input.Customer)

if(!currency){
    api.addWarning('Currency is missing for the customer')
    return
}

return currency