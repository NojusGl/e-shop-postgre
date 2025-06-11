
CREATE OR REPLACE FUNCTION check_order_limit() RETURNS TRIGGER AS $$
DECLARE
    order_count INTEGER;
BEGIN
    SELECT COUNT(*) INTO order_count
    FROM Uzsakymas
    WHERE PIRK_ID = NEW.PIRK_ID AND DATE(UzsakymoData) = DATE(NEW.UzsakymoData);

    IF order_count >= 5 THEN
        RAISE EXCEPTION 'Per dieną galima padaryti daugiausiai penkis užsakymus (tam pačiam vartotojui)';
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER order_limit_trigger
BEFORE INSERT ON Uzsakymas
FOR EACH ROW EXECUTE PROCEDURE check_order_limit();

-- |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| --

CREATE OR REPLACE FUNCTION check_factories() RETURNS TRIGGER AS $$
DECLARE
    factory_count INTEGER;
BEGIN
    SELECT COUNT(*) INTO factory_count FROM Gaminimas WHERE PROD_ID = NEW.PROD_ID;
    IF factory_count > 3 THEN
        RAISE EXCEPTION 'Produktas negali būti pagamintas per daugiau kaip tris gamyklas.';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER factory_check
BEFORE INSERT ON Gaminimas
FOR EACH ROW EXECUTE PROCEDURE check_factories();