CREATE TABLE IF NOT EXISTS clothes (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(50) NOT NULL,
    category VARCHAR(50) NOT NULL,
    name VARCHAR(255) NOT NULL,
    img VARCHAR(255) NOT NULL,
    detail_size VARCHAR(10) NULL
);