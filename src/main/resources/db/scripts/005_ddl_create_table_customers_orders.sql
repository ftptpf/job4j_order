CREATE TABLE IF NOT EXISTS customers_orders (
    customer_id INTEGER UNIQUE REFERENCES customers ,
    order_id INTEGER REFERENCES orders
);

COMMENT ON TABLE customers_orders IS 'Таблица связи @OneToMany клиента и его заказов';
COMMENT ON COLUMN customers_orders.customer_id IS 'Идентификатор клиента';
COMMENT ON COLUMN customers_orders.order_id IS 'Идентификатор заказа';

