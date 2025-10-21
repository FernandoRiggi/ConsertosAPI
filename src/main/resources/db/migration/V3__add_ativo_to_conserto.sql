ALTER TABLE conserto ADD COLUMN ativo BOOLEAN;
UPDATE conserto SET ativo = TRUE;