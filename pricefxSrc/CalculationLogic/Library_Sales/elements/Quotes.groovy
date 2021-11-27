import net.pricefx.domain.Quote

List<Quote> getByYear(Integer year){
    def filters = [
            Filter.greaterOrEqual('targetDate', year + '-01-01'),
            Filter.lessThan('targetDate', (year+1) + "-01-01")
    ]
     return api.find(
            'Q',
            0,
            100,
            'targetDate',
            null,
            *filters
    )
}