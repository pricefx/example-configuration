import com.googlecode.genericdao.search.Filter

def pricelistIterator = api.stream("PL", null, Filter.equal("approvalState", "APPROVED"))
def targetDates = pricelistIterator?.collectEntries { pl -> [(pl.id): (pl.targetDate)] }
pricelistIterator?.close()

// TODO uncomment next line (this line was commented so the stub of this logic could be successfully deployed to your partition)
// def pricelistIds = targetDates.keySet() as List

// TODO place your code here
// HINTS:
// - use only PLIs from Priceslists listed in variable "pricelistIds"
// - target dates of the Pricelists are in variable "targetDates"