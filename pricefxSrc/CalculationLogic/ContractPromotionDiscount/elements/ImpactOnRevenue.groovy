if (out.RevenueLastYear != null && out.PromotionDiscount != null) {
    return out.RevenueLastYear * out.PromotionDiscount * -1.0
} else {
    api.addWarning("Cannot calculate ImpartOnRevenue, because either" +
            "the Last Year Revenue or Promotion Discount is not available.")
}