CREATE TABLE IF NOT EXISTS purchases (
    id SERIAL PRIMARY KEY,
    supplier_id SERIAL,
    date_purchase date,
    comments VARCHAR(255) NULL,
    total FLOAT,
    CONSTRAINT fk_supplier
          FOREIGN KEY(supplier_id)
    	  REFERENCES suppliers(id)
);

CREATE TABLE IF NOT EXISTS details_purchase (
    id SERIAL PRIMARY KEY,
    purchase_id SERIAL,
    clothes_id SERIAL,
    count_items INT,
    price_per_unit FLOAT,
    total FLOAT,
    CONSTRAINT fk_purchase
          FOREIGN KEY(purchase_id)
    	  REFERENCES purchases(id),
    CONSTRAINT fk_clothes_details_purchase
          FOREIGN KEY(clothes_id)
    	  REFERENCES clothes(id)
);
