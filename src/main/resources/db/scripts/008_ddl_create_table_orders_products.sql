CREATE TABLE IF NOT EXISTS orders_products (
    order_id INTEGER REFERENCES customers ,
    product_id INTEGER REFERENCES orders ,
    PRIMARY KEY (order_id, product_id)
);

COMMENT ON TABLE orders_products IS 'Таблица связи заказов и продуктов';
COMMENT ON COLUMN orders_products.order_id IS 'Идентификатор заказа';
COMMENT ON COLUMN orders_products.product_id IS 'Идентификатор продукта';