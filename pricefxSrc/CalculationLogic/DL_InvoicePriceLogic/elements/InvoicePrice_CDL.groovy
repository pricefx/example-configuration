def listPrice = api.userEntry("ListPrice")
def discount = api.userEntry("Discount")

if(listPrice == null || discount == null) {
  return null
}

return listPrice - discount