/**
 * Formats the date according to how Pricefx stores dates (as strings) in the backend
 * @param date
 * @return
 */
String formatDate(Date date){
    return date.format('yyyy-MM-dd')
}

Date today(){
    return new Date()
}

Date oneYearAgo(){
    Calendar cal = Calendar.getInstance()
    cal.setTime(today())
    cal.add(Calendar.YEAR, -1)
    return cal.getTime()
}