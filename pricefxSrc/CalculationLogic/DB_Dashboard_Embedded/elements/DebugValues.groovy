def m = api.newMatrix("Name", "Value")

//Year value was passed from the calling Main dashboard
m.addRow("Year", api.input("Year"))
//CustomerId value was passed from the calling Main dashboard
m.addRow("CustomerId", api.input("CustomerId"))

return m