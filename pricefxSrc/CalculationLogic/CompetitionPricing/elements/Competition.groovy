/* This code sample is only for training purposes. Production code would use more filters. */
return api.productCompetition(
        Filter.equal("competitionType", "Online"),
        Filter.lessThan("infoDate", api.targetDate()?.format("yyyy-MM-dd"))
)?.sort { a, b -> b.infoDate <=> a.infoDate }?.find()