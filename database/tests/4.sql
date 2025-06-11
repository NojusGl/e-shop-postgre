
-- 4) parodyti, kur buvo išsaugota virtualios lentelės užklausa
SELECT viewname, definition
FROM pg_views
WHERE schemaname = 'schema'
AND viewname = 'branguskompiuteriai';

SELECT viewname, definition
FROM pg_views
WHERE schemaname = 'schema'
AND viewname = 'pirkejuuzsakymusuma';