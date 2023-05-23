CREATE TABLE IF NOT EXISTS stocks (
    id SERIAL PRIMARY KEY,
    clothes_id SERIAL,
    amount INT,
    CONSTRAINT fk_clothes
          FOREIGN KEY(clothes_id)
    	  REFERENCES clothes(id)
);
