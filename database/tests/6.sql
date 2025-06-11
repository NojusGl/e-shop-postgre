
-- 6) parodyti, kad jie atsirado
SELECT * FROM Pirkejas;
SELECT * FROM Produktas;
SELECT * FROM Gamykla;
SELECT * FROM Uzsakymas;
SELECT * FROM Gaminimas;

--  materialized views
SELECT * FROM UzsakymoInfo;

-- views
SELECT * FROM BrangusKompiuteriai
ORDER BY Kaina DESC;

SELECT * FROM PirkejuUzsakymuSuma
ORDER BY Suma ASC;