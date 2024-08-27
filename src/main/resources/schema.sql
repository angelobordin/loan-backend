CREATE TABLE IF NOT EXISTS loan (
    id SERIAL PRIMARY KEY,
    data_emprestimo TIMESTAMP,  -- Armazena data e hora
    moeda VARCHAR(255),
    valor_obtido NUMERIC,
    data_vencimento TIMESTAMP,  -- Armazena data e hora
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);