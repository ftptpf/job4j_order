CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY NOT NULL ,
    name TEXT UNIQUE NOT NULL ,
    cost INTEGER CHECK ( cost > 0 )
);

COMMENT ON TABLE products IS 'Продукты';
COMMENT ON COLUMN products.id IS 'Идентификатор продукта';
COMMENT ON COLUMN products.name IS 'Название продукта';
COMMENT ON COLUMN products.cost IS 'Стоимость продукта';