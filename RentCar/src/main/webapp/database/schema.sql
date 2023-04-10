create database test;
use test;
commit;

CREATE TABLE board (
   board_number INTEGER PRIMARY KEY AUTO_INCREMENT,
   type bit(1) NOT NULL,
   board_writer VARCHAR(15),
   title VARCHAR(100) NOT NULL,
   content VARCHAR(9999) NOT NULL,
   created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   FOREIGN KEY (board_writer) REFERENCES client (client_id)
) AUTO_INCREMENT = 99;

CREATE USER 'scott'@'%' IDENTIFIED BY 'tiger';
GRANT ALL PRIVILEGES ON *.* TO 'scott'@'%'
     WITH GRANT OPTION;
     
commit;

CREATE TABLE venue (
   venue_code CHAR(3) PRIMARY KEY,
   venue_name varchar(30),
   reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE vehicle (
   vehicle_code INTEGER PRIMARY KEY AUTO_INCREMENT,
   vehicle_name VARCHAR(30) NOT NULL,
   hourly_rate INTEGER NOT NULL,
   venue_code CHAR(3),
   reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   FOREIGN KEY (venue_code) REFERENCES venue(venue_code)
) AUTO_INCREMENT = 1000;


INSERT INTO vehicle (vehicle_code, vehicle_name, hourly_rate, venue_code) VALUES 
('v0001','K5', 17000, 'A01');


CREATE TABLE booking(
   booking_code INTEGER PRIMARY KEY AUTO_INCREMENT,
   reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   rental_time INTEGER NOT NULL,
   client_id VARCHAR(15) NOT NULL,
   driver_code CHAR(15),
   vehicle_code INTEGER,
   book_date TIMESTAMP NOT NULL,
   return_date TIMESTAMP NOT NULL,
   FOREIGN KEY (client_id) REFERENCES client(client_id),
   FOREIGN KEY (driver_code) REFERENCES client(driver_code),
   FOREIGN KEY (vehicle_code) REFERENCES vehicle(vehicle_code)
) AUTO_INCREMENT = 10000000;

CREATE VIEW reservation_info AS
SELECT 
   b.booking_code as reservation_code,
   b.reg_date as regist_date,
   b.rental_time as rental_time,
   b.vehicle_code as vehicle_code,
   b.client_id as client_id,
   (SELECT client_name FROM client WHERE client_id = b.client_id) as client_name,
   b.driver_code as driver_code,
   b.book_date as booking_date,
   b.return_date as return_date,
   (SELECT v.hourly_rate * b.rental_time FROM vehicle v WHERE v.vehicle_code = b.vehicle_code) as rental_cost,
   (SELECT venue_name FROM venue WHERE venue_code = (SELECT venue_code FROM vehicle WHERE vehicle_code = b.vehicle_code)) AS vehicle_venue
FROM booking b
ORDER BY reservation_code;
