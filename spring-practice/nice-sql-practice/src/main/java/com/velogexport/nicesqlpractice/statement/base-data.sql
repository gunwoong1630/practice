CREATE TABLE car(
                    car_id BIGINT NOT NULL PRIMARY KEY,
                    car_brand VARCHAR(20) NOT NULL,
                    car_name VARCHAR(20) NOT NULL,
                    car_type VARCHAR(10) NOT NULL
);

INSERT INTO car values(1, 'HYUNDAI', 'avante', 'AUTO');
