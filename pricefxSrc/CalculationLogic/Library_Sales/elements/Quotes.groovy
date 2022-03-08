List<Map> getDraftsByYear(Integer year) {
    def filters = [
            Filter.equal('quoteStatus', 'DRAFT'),
            Filter.greaterOrEqual('targetDate', year + '-01-01'),
            Filter.lessThan('targetDate', (year + 1) + "-01-01")
    ]

    // Suppress IntelliJ warnings by casting to List<Map>: Studio is tricking IntelliJ into believing this method returns a net.pricefx.domain.Quote
    return api.find(
            'Q',
            0,
            100,
            'targetDate',
            null,
            *filters
    ) as List<Map>
}

List<Map> getByYear(Integer year) {
    def filters = [
            Filter.greaterOrEqual('targetDate', year + '-01-01'),
            Filter.lessThan('targetDate', (year + 1) + "-01-01")
    ]
    return api.find(
            'Q',
            0,
            100,
            'targetDate',
            null,
            *filters
    ) as List<Map>
}