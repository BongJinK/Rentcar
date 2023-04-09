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
   vehicle_code CHAR(5) PRIMARY KEY,
   vehicle_name VARCHAR(30) NOT NULL,
   hourly_rate INTEGER NOT NULL,
   venue_code CHAR(3),
   reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   is_available CHAR(1) CHECK (is_available IN ('Y', 'N')) NOT NULL,
   FOREIGN KEY (venue_code) REFERENCES venue(venue_code)
);

CREATE TABLE booking(
   booking_code CHAR(8) PRIMARY KEY,
   reg_date TIMESTAMP NOT NULL,
   rental_time INTEGER NOT NULL,
   driver_code char(12),
   vehicle_code VARCHAR(5),
   book_date TIMESTAMP NOT NULL,
   return_date TIMESTAMP NOT NULL,
   FOREIGN KEY (driver_code) REFERENCES client(driver_code),
   FOREIGN KEY (vehicle_code) REFERENCES vehicle(vehicle_code)
);


