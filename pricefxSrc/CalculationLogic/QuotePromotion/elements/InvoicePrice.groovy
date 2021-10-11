if (out.ListPrice == null) {
    api.addWarning("Cannot calculate Invoice Price, because List Price is not available.")
    return
}

def promotionDiscount = out.PromotionDiscountPct ?: 0.0
def volumeDiscount = out.VolumeDiscountPct ?: 0.0

return out.ListPrice * (1.0 - promotionDiscount - volumeDiscount)