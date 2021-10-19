if (out.RevenueLastYear != null && out.VolumeDiscountMap) {
    def worstPromotionDiscount = out.VolumeDiscountMap?.sort { -it.key }?.find()?.value
    return out.RevenueLastYear * worstPromotionDiscount * -1.0
} else {
    api.addWarning("Cannot calculate the estimated impact on Revenue, " +
            "because either Last Year Revenue or Promotion Discount is unavailable.")
}

