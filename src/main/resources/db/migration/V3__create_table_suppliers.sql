CREATE TABLE IF NOT EXISTS suppliers (
    id SERIAL PRIMARY KEY,
    nit VARCHAR(50) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(100) NULL
);