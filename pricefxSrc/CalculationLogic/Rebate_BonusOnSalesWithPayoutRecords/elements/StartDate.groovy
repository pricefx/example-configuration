def startDateAsString = api.currentItem()?.startDate
if (startDateAsString) {
    return api.parseDate("yyyy-MM-dd", startDateAsString)
} else {
    return out.Today /* fallback in case user deletes the value and recalculate */
}