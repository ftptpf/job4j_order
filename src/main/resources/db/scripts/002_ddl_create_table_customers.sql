CREATE TABLE IF NOT EXISTS customers (
    id SERIAL PRIMARY KEY NOT NULL ,
    name TEXT NOT NULL ,
    phone INTEGER UNIQUE NOT NULL ,
    money INTEGER DEFAULT 0 CHECK ( money >= 0 ) ,
    card_id INTEGER REFERENCES cards(id) DEFAULT 1
);

COMMENT ON TABLE customers IS 'Клиенты';
COMMENT ON COLUMN customers.id IS 'Идентификатор клиента';
COMMENT ON COLUMN customers.name IS 'Имя клиента';
COMMENT ON COLUMN customers.phone IS 'Телефон клиента';
COMMENT ON COLUMN customers.money IS 'Деньги на счету клиента';
COMMENT ON COLUMN customers.card_id IS 'Бонусная карта клиента';
