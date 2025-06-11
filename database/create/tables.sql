
CREATE TABLE Pirkejas (
    PIRK_ID           SERIAL          NOT NULL, -- jei pasikeistų raktas
    Vardas            VARCHAR(30)     NOT NULL,
    Pavarde           VARCHAR(30)     NOT NULL,
    Adresas           VARCHAR(20)     NOT NULL,
    Telefonas         BIGINT          NOT NULL,
    PRIMARY KEY (PIRK_ID),
    CONSTRAINT AdresoDidzRaide CHECK (Adresas ~ '^[A-Z].*$')
);

CREATE TABLE Produktas (
    PROD_ID          INTEGER       NOT NULL,    
    Pavadinimas      VARCHAR(30)   NOT NULL,
    Aprasymas        VARCHAR(120)  DEFAULT 'Puikus',
    Kaina            FLOAT         DEFAULT 500,
    PRIMARY KEY (PROD_ID),
    CONSTRAINT TeigiamaKaina CHECK(Kaina >= 0)
);

CREATE TABLE Uzsakymas (
    U_ID           INTEGER    NOT NULL,
    PIRK_ID        INTEGER    NOT NULL,
    UzsakymoData   DATE       NOT NULL,
    PROD_ID        INTEGER    NOT NULL,
    Kiekis         INTEGER    DEFAULT 1,
    PRIMARY KEY (U_ID),
    CONSTRAINT IPirkeja  FOREIGN KEY (PIRK_ID) REFERENCES Pirkejas  ON DELETE CASCADE ON UPDATE SET NULL,
    CONSTRAINT IProdukta FOREIGN KEY (PROD_ID) REFERENCES Produktas ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT TeisingaData CHECK(UzsakymoData > '1900-01-01' AND UzsakymoData < CURRENT_DATE + INTERVAL '1 day')
);

CREATE TABLE Gamykla (
    GAM_ID           INTEGER       NOT NULL,
    Pavadinimas      VARCHAR(30)   NOT NULL,
    Adresas          VARCHAR(20)   NOT NULL,
    PRIMARY KEY (GAM_ID)
);

CREATE TABLE Gaminimas (
    PROD_ID          INTEGER       NOT NULL,
    GAM_ID           INTEGER       NOT NULL,
    PRIMARY KEY (PROD_ID, GAM_ID),
    FOREIGN KEY (PROD_ID) REFERENCES Produktas ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (GAM_ID) REFERENCES Gamykla ON DELETE CASCADE ON UPDATE CASCADE
);