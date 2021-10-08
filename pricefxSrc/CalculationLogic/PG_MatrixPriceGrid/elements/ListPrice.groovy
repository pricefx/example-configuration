if (out.BasePrice != null && out.VolumeDiscountPct != null) {
    return out.BasePrice * (1.0 - out.VolumeDiscountPct)
} else {
    api.addWarning("Cannot calculate the List Price, because Base Price or Volume Discount % is missing.")
    return
}