
CREATE MATERIALIZED VIEW UzsakymoInfo AS
SELECT Uz.Uzsakymodata,
       Pirk.Vardas || ' ' || Pirk.pavarde AS Pirkejas,
       Prod.Pavadinimas AS produktas,
       Prod.Aprasymas,
       Prod.Kaina
FROM Uzsakymas Uz
JOIN Pirkejas Pirk ON Uz.PIRK_ID = Pirk.PIRK_ID
JOIN Produktas Prod ON Uz.PROD_ID = Prod.PROD_ID;