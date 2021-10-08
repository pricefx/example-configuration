if (out.Competition?.price != null && out.CompetitivePositioning != null) {
    return out.Competition.price * out.CompetitivePositioning
} else {
    api.addWarning("Cannot calculate ListPrice because CompPrice or Positioning is not available.")
    return null
}