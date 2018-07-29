CREATE SEQUENCE stores_sequence START 1 INCREMENT 1;

CREATE TABLE stores (
  id integer NOT NULL DEFAULT nextval('stores_sequence'),
  city varchar(100),
  address text
);


CREATE SEQUENCE items_sequence START 1 INCREMENT 1;

CREATE TABLE items(
  id integer NOT NULL DEFAULT nextval('items_sequence'),
  serial_number varchar(100),
  name varchar(100),
  description text
);


CREATE SEQUENCE items_location_sequence START 1 INCREMENT 1;

CREATE TABLE items_location(
  id integer NOT NULL DEFAULT nextval('items_location_sequence'),
  store_id integer,
  item_id integer
);


CREATE SEQUENCE reviews_sequence START 1 INCREMENT 1;

CREATE TABLE reviews(
  id integer NOT NULL DEFAULT nextval('reviews_sequence'),
  item_id integer,
  nr_stars int,
  comment text
);
