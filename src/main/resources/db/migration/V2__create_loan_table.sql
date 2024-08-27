CREATE TABLE loan (
    id SERIAL PRIMARY KEY,
    dataEmprestimo TIMESTAMP NOT NULL,
    moeda VARCHAR(3) NOT NULL,
    valorObtido NUMERIC NOT NULL,
    dataVencimento TIMESTAMP NOT NULL,
    customer_id INTEGER,
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE
);
