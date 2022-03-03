DROP TABLE IF EXISTS metadata;

CREATE TABLE metadata (
  id INT(11) NOT NULL,
  name VARCHAR(50) NULL DEFAULT NULL,
  description VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (id)
);

INSERT INTO metadata (id, name, description) VALUES (1, 'IPhone 6S', 'Mobile');
INSERT INTO metadata (id, name, description) VALUES (2, 'Samsung Galaxy', 'Mobile');
INSERT INTO metadata (id, name, description) VALUES (3, 'Lenovo', 'Laptop');
INSERT INTO metadata (id, name, description) VALUES (4, 'LG', 'Telivision');