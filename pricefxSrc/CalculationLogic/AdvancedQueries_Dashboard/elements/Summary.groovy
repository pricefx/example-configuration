def ctx = api.getDatamartContext()

def dm1 = ctx.getDatamart("Transaction")
def q1 = ctx.newQuery(dm1)
        .select("Currency")
        .select("InvoiceDate")
        .select("InvoicePrice")
        .select("ProductId")
        .select("Quantity")
        .select("TransactionId")
        .select("InvoiceDateQuarter")
        .select("CountryCode")

        .where(Filter.equal("CountryCode", input.CountryCode))
        .where(Filter.equal("ProductId", input.ProductId))


def dm2 = ctx.getDataSource("ProductCompetitionData")
def q2 = ctx.newQuery(dm2)
        .select("ProductId")
        .select("CountryCode")
        .select("ValidFrom")
        .select("ValidTo")
        .select("Price")
        .select("Currency")


def sql = '''
SELECT
    T1.CountryCode        AS "CountryCode",
    T1.ProductId          AS "ProductId",
    T1.InvoiceDateQuarter AS "InvoiceDateQuarter", 
    AVG( T1.InvoicePrice / T1.Quantity )  AS "InvoicePricePerUnit" ,
    T1.Currency           AS "InvoicePriceCurrency",
    AVG(T2.Price)         AS "CompetitorPricePerUnit",
    T2.Currency           AS "CompetitorPriceCurrency"
     
FROM T1
LEFT JOIN T2

    ON  T1.ProductId   = T2.ProductId
        AND  T1.CountryCode = T2.CountryCode
        AND  T2.ValidFrom <= T1.InvoiceDate  AND  T1.InvoiceDate < T2.ValidTo
    
GROUP BY
    T1.CountryCode,
    T1.ProductId,
    T1.InvoiceDateQuarter,
    T1.Currency,
    T2.Currency

ORDER BY
    T1.CountryCode,
    T1.ProductId,
    T1.InvoiceDateQuarter
    
LIMIT 30                                      
'''


def result = ctx.executeSqlQuery(sql, q1, q2)

return result ? result.toResultMatrix() : null
