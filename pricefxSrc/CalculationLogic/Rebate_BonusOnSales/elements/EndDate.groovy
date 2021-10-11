def endDateAsString = api.currentItem()?.endDate
if (endDateAsString) {
    return api.parseDate("yyyy-MM-dd", endDateAsString)
} else {
    return out.Today /* fallback in case user deletes the value and recalculate */
}