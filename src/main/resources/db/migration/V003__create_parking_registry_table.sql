CREATE TABLE parking_registry(
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    initial_time DATETIME NOT NULL,
    -- final_time column is here just to be used by the payment service
    final_time DATETIME,
    price_per_minute BIGINT NOT NULL,
    parking_spot_id BIGINT(20) NOT NULL,
    floor_name VARCHAR(20) NOT NULL,
    FOREIGN KEY (parking_spot_id) REFERENCES parking_spot (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO parking_registry (initial_time, final_time, price_per_minute, parking_spot_id, floor_name) VALUES ("2021/12/11 12:00:00", null, 1.00, 120, "second");
INSERT INTO parking_registry (initial_time, final_time, price_per_minute, parking_spot_id, floor_name) VALUES ("2021/12/11 12:00:00", null, 1.00, 115, "second");
INSERT INTO parking_registry (initial_time, final_time, price_per_minute, parking_spot_id, floor_name) VALUES ("2021/12/11 12:00:00", null, 2.00, 105, "first");
INSERT INTO parking_registry (initial_time, final_time, price_per_minute, parking_spot_id, floor_name) VALUES ("2021/12/11 12:00:00", null, 3.00, 15, "ground");
INSERT INTO parking_registry (initial_time, final_time, price_per_minute, parking_spot_id, floor_name) VALUES ("2021/12/11 12:00:00", null, 3.00, 11, "ground");