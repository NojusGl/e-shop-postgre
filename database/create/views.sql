
CREATE VIEW BrangusKompiuteriai(Pavadinimas, Aprasymas, Kaina)
AS SELECT Pavadinimas, Aprasymas, Kaina 
FROM Produktas 
WHERE Kaina > 1150.00;

CREATE VIEW PirkejuUzsakymuSuma AS
SELECT DISTINCT PIRK_ID, SUM(Kiekis) AS Suma
FROM Uzsakymas
GROUP BY PIRK_ID;