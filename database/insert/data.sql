
-- Pirkejai
INSERT INTO Pirkejas VALUES (1, 'Jonas', 'Puotautojas', 'Daukanto g.', 37061818181);
INSERT INTO Pirkejas VALUES (2, 'Aras', 'Baras', 'Sventes g.', 37069797201);
INSERT INTO Pirkejas VALUES (3, 'Saulius', 'Puotautojas', 'Daukanto g.', 37068888771);
INSERT INTO Pirkejas VALUES (4, 'Ona', 'Duonute', 'Minties g.', 37061234567);
INSERT INTO Pirkejas VALUES (5, 'Alfredas', 'Baze', 'Laisves g.', 37067654321);
INSERT INTO Pirkejas VALUES (6, 'Arnas', 'Karys', 'Laisves g.', 37067654344);

-- Gamykla
INSERT INTO Gamykla VALUES(1000,'QuantumCore Technologies', 'Duobes g.');
INSERT INTO Gamykla VALUES(1050,'Nebula Systems', 'Minties g.');
INSERT INTO Gamykla VALUES(1100,'PentaByte Solutions', 'Laisves g.');
INSERT INTO Gamykla VALUES(1150,'InfiniTech Creations', 'Sventes g.');
INSERT INTO Gamykla VALUES(1200,'SiliconOracle Innovations', 'Duobes g.');
INSERT INTO Gamykla VALUES(1250,'ElectroNimbus Computing', 'Artima g.');

-- Produktai
INSERT INTO Produktas VALUES(100, 'AuroraByte Quantum 3', 'Nuostabus', 1200.00);
INSERT INTO Produktas VALUES(101, 'CrimsonCore Pulsar 1', 'Geriausias', 700.00);
INSERT INTO Produktas VALUES(102, 'DeltaDrive Nebula 4', 'Išskirtinis', 1200.50);
INSERT INTO Produktas VALUES(103, 'EchoEngine Galaxy 2', 'Nepakartojamas', 1400.50);
INSERT INTO Produktas VALUES(104, 'FoxtrotFlash Quasar 5', 'Žavingas', 400.00);
INSERT INTO Produktas VALUES(105, 'GolfGrid Nova 3', 'Greitas', 700.00);
INSERT INTO Produktas VALUES(106, 'HotelHardware Cosmos 1', 'Neaplenkiamas', 900.00);
INSERT INTO Produktas VALUES(107, 'IndiaInterface Stellar 2', 'Lengvas', 400.00);
INSERT INTO Produktas VALUES(108, 'JuliettJunction Comet 5', 'Didelis', 600.00);
INSERT INTO Produktas VALUES(109, 'KiloKernel Meteor 4', 'Mažas', 100.00);
INSERT INTO Produktas VALUES(110, 'LimaLogic Aurora 3', 'Galingas', 350.00);
INSERT INTO Produktas VALUES(111, 'MikeMatrix Eclipse 1', 'Profesionalus', 1850.00);
INSERT INTO Produktas VALUES(112, 'NovemberNetwork Orion 2', 'Prabangus', 2050.00);

-- Gaminimas
INSERT INTO Gaminimas VALUES (100, 1000);
INSERT INTO Gaminimas VALUES (100, 1050);
INSERT INTO Gaminimas VALUES (101, 1100);
INSERT INTO Gaminimas VALUES (101, 1150);
INSERT INTO Gaminimas VALUES (102, 1200);
INSERT INTO Gaminimas VALUES (102, 1250);
INSERT INTO Gaminimas VALUES (103, 1000);
INSERT INTO Gaminimas VALUES (103, 1050);
INSERT INTO Gaminimas VALUES (104, 1100);
INSERT INTO Gaminimas VALUES (104, 1150);
INSERT INTO Gaminimas VALUES (105, 1200);
INSERT INTO Gaminimas VALUES (105, 1250);
INSERT INTO Gaminimas VALUES (106, 1000);
INSERT INTO Gaminimas VALUES (106, 1050);
INSERT INTO Gaminimas VALUES (107, 1100);
INSERT INTO Gaminimas VALUES (107, 1150);
INSERT INTO Gaminimas VALUES (108, 1200);
INSERT INTO Gaminimas VALUES (108, 1250);
INSERT INTO Gaminimas VALUES (109, 1000);
INSERT INTO Gaminimas VALUES (109, 1050);
INSERT INTO Gaminimas VALUES (110, 1100);
INSERT INTO Gaminimas VALUES (110, 1150);
INSERT INTO Gaminimas VALUES (111, 1200);
INSERT INTO Gaminimas VALUES (111, 1250);
INSERT INTO Gaminimas VALUES (112, 1000);
INSERT INTO Gaminimas VALUES (112, 1050);

-- Uzsakymas
INSERT INTO Uzsakymas VALUES(501, 1, '2024-01-01', 100, 1);
INSERT INTO Uzsakymas VALUES(502, 1, '2024-01-02', 107, 2);
INSERT INTO Uzsakymas VALUES(503, 2, '2023-01-01', 110, 1);
INSERT INTO Uzsakymas VALUES(504, 2, '2023-04-07', 108, 1);
INSERT INTO Uzsakymas VALUES(505, 3, '2022-05-01', 104, 1);
INSERT INTO Uzsakymas VALUES(506, 4, '2020-01-01', 102, 5);
INSERT INTO Uzsakymas VALUES(507, 5, '2021-11-15', 103, 1);
INSERT INTO Uzsakymas VALUES(508, 5, '2024-01-05', 105, 8);