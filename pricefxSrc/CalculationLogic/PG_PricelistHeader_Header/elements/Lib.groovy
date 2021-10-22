import groovy.transform.Field

@Field Long MOCK_PRICE_GRID_ID = 843

Long getPriceGridId(){
    if(api.debugMode){
        return MOCK_PRICE_GRID_ID // Alternatively, manually create a preset with an extra input for debugging.
    } else {
        return api.currentItem().id
    }
}
