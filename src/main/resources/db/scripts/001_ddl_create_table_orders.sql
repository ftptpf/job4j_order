CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY NOT NULL ,
    name TEXT UNIQUE NOT NULL ,
    description TEXT NOT NULL
);

COMMENT ON TABLE orders IS 'Заказы';
COMMENT ON COLUMN orders.id IS 'Идентификатор заказа';
COMMENT ON COLUMN orders.name IS 'Название заказа';
COMMENT ON COLUMN orders.description IS 'Описание заказа';