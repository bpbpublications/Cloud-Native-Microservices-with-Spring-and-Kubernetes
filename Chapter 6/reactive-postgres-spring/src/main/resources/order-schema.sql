DROP TABLE IF EXISTS orders ;
CREATE TABLE orders ( id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, p_name VARCHAR(100) NOT NULL, qty integer,price decimal);