return api.productCompetition(
        Filter.equal("competitionType", "Online"),
        Filter.lessThan("infoDate", api.targetDate()?.format("yyyy-MM-dd"))
)?.sort { a, b -> b.infoDate <=> a.infoDate }?.find()