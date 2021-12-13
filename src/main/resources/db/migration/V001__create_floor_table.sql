CREATE TABLE floor(
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    weight_capacity DOUBLE NOT NULL,
    ceiling_height DOUBLE NOT NULL,
    current_weight_capacity DOUBLE NOT NULL,
    spot_quantity INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO floor (name, weight_capacity, ceiling_height, current_weight_capacity, spot_quantity)
VALUES ('ground', 200000.00, 4.00, 200000.00, 30);
INSERT INTO floor (name, weight_capacity, ceiling_height, current_weight_capacity, spot_quantity)
VALUES ('first', 10000.00, 1.80, 10000.00, 50);
INSERT INTO floor (name, weight_capacity, ceiling_height, current_weight_capacity, spot_quantity)
VALUES ('second', 10000.00, 1.60, 10000.00, 50);