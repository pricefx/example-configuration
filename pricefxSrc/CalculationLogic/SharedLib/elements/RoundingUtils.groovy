BigDecimal round(BigDecimal number, int noDecimals) {
    if(number == null) {
        return null
    }
    return number.setScale(noDecimals, RoundingMode.HALF_UP)
}