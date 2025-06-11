
DROP TABLE IF EXISTS Uzsakymas CASCADE;
    -- psql:drop/tables.sql:2: NOTICE:  drop cascades to 2 other objects
    -- DETAIL:  drop cascades to view pirkejuuzsakymusuma
    -- drop cascades to materialized view uzsakymoinfo
DROP TABLE IF EXISTS Gaminimas CASCADE;

DROP TABLE IF EXISTS Pirkejas CASCADE;
DROP TABLE IF EXISTS Produktas CASCADE;
    -- psql:drop/tables.sql:6: NOTICE:  drop cascades to view branguskompiuteriai
DROP TABLE IF EXISTS Gamykla CASCADE;