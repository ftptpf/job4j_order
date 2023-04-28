CREATE TABLE IF NOT EXISTS cards (
    id SERIAL PRIMARY KEY NOT NULL ,
    name TEXT UNIQUE NOT NULL ,
    discount INTEGER NOT NULL
);

COMMENT ON TABLE cards IS 'Бонусные карты';
COMMENT ON COLUMN cards.id IS 'Идентификатор карты';
COMMENT ON COLUMN cards.name IS 'Название карты';
COMMENT ON COLUMN cards.discount IS 'Скидка % по карте';
