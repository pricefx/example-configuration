if(out.BasePrice == null
        || out.MarginAdjAbs == null
        || out.AttributeAdjAbs == null) {
  api.addWarning("List Price cannot be calculated: missing parameter(s).")
  return null
}

def listPrice = out.BasePrice + out.MarginAdjAbs + out.AttributeAdjAbs
def roundedListPrice = libs.SharedLib.RoundingUtils.round(listPrice, 2)

api.trace("List Price", listPrice)
api.trace("Rounded List Price", roundedListPrice)

return roundedListPrice