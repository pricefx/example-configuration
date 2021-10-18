if(out.BasePrice == null
        || out.MarginAdjAbs == null
        || out.AttributeAdjPct == null) {
  api.addWarning("Attribute Adjustment cannot be calculated: missing parameter(s)")
  return null
}

if(out.AttributeAdjPct == 1) {
  api.addWarning("Attribute Adjustment cannot be 100% -> division by 0")
  return null
}

return (out.BasePrice + out.MarginAdjAbs) * out.AttributeAdjPct / (1 - out.AttributeAdjPct)