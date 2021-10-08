def currentItem = api.currentItem()

if (api.isDebugMode()) {
    currentItem = [
            label               : "PricelistHeader",
            configuration       :
                    ''' 
                        {
                          "inputs": [],
        
                          "headerInputs": [
                            {
                              "name": "SpecialAdjPct",
                              "label": "Enter Special Adjustment (in %)",
                              "type": "USERENTRY",
                              "value": 0.02
                            }
                          ],
                          
                          "outputs": [],
                          
                          "outputChartDefinition": {}
                        }
                    ''',
            priceGridType       : "SIMPLE",
            headerTypeUniqueName: "PricelistHeaderType",

            id                  : 363
    ]
}

return currentItem

