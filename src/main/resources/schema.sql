CREATE TABLE IF NOT EXISTS loan (
    id SERIAL PRIMARY KEY,                       -- Identificador único para cada empréstimo
    data_emprestimo DATE NOT NULL,               -- Data do empréstimo
    moeda VARCHAR(3) NOT NULL,                   -- Moeda do empréstimo, usando código de 3 letras (ex: USD, EUR)
    valor_obtido NUMERIC(15, 2) NOT NULL,        -- Valor obtido no empréstimo
    data_vencimento DATE NOT NULL                -- Data de vencimento do empréstimo
);
