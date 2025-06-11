-- 7) parodyti, kad veikia trigeris (kažkuris vienas)
-- Per dieną galima padaryti daugiausiai penkis užsakymus (tam pačiam vartotojui)
INSERT INTO Uzsakymas VALUES(509, 6, '2024-05-17', 101, 1);
INSERT INTO Uzsakymas VALUES(510, 6, '2024-05-17', 102, 2);
INSERT INTO Uzsakymas VALUES(511, 6, '2024-05-17', 103, 3);
INSERT INTO Uzsakymas VALUES(512, 6, '2024-05-17', 104, 4);
INSERT INTO Uzsakymas VALUES(513, 6, '2024-05-17', 105, 5);
INSERT INTO Uzsakymas VALUES(514, 6, '2024-05-17', 106, 6);

-- Produktas negali būti pagamintas per daugiau kaip tris gamyklas
-- INSERT INTO Gaminimas VALUES (100, 1000); -- already exists
-- INSERT INTO Gaminimas VALUES (100, 1050); -- already exists
-- INSERT INTO Gaminimas VALUES (100, 1100);
-- INSERT INTO Gaminimas VALUES (100, 1150);