import net.pricefx.common.util.CalendarUtil.TimePeriod
import net.pricefx.common.util.CalendarUtil.TimeUnit

/*
    The CalculationBase filter will be used for Rebate Allocation process.
    We redefine the default filter here, because we want to use different end date.
    Otherwise we would not need to change it.
 */
calculationBase.clear()
calculationBase.include(out.CustomerGroup)
calculationBase.include(out.ProductGroup)
calculationBase.include(
        new TimePeriod(out.StartDate, out.EndDateOrToday, TimeUnit.DAY)
)

/*
  this date field will be later redefined in the Rebate Allocation process,
  but if we set it up here, we can use see the effect of this filter already on the Rebate Record Details page,
  under sub-screen "Calculation Base"
 */
calculationBase.setDateFieldName("InvoiceDate")

api.trace("calculationBase", api.jsonEncode(calculationBase)) //TODO comment out in production code
//api.trace("calculationBase.dump", calculationBase.dump())  //if you want to verify the DateFieldValue
