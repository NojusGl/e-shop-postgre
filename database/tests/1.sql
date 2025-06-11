
-- 1) parodyti, kad duomenų bazėje nėra objektų:
-- 	1) lentelių
-- 	2) indeksų
-- 	3) virtualių lentelių
-- 	4) trigerių
-- 	(parodyti visus tuos objektus)

-- List base tables
SELECT table_name AS base_table
FROM information_schema.tables
WHERE table_schema = 'schema'
AND table_type = 'BASE TABLE';

-- List indexes
SELECT indexname AS index_name
FROM pg_indexes
WHERE schemaname = 'schema'
AND indexname NOT LIKE '%_pkey';

-- List virtual tables (views)
SELECT table_name AS views
FROM information_schema.views
WHERE table_schema = 'schema';

-- List triggers
SELECT trigger_name
FROM information_schema.triggers
WHERE trigger_schema = 'schema';