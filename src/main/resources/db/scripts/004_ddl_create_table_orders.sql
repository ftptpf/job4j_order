CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY NOT NULL ,
    description TEXT NOT NULL ,
    cost INTEGER CHECK ( cost > 0 ) ,
    status BOOLEAN DEFAULT true ,
    customer_id INTEGER REFERENCES customers(id)
);

COMMENT ON TABLE orders IS 'Заказы';
COMMENT ON COLUMN orders.id IS 'Идентификатор заказа';
COMMENT ON COLUMN orders.description IS 'Описание заказа';
COMMENT ON COLUMN orders.cost IS 'Стоимость заказа';
COMMENT ON COLUMN orders.status IS 'Статус заказа';
