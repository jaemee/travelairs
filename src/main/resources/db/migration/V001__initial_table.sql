CREATE TABLE IF NOT EXISTS `flights` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `flightNumber` varchar(20),
    `departurePort` varchar(20),
    `arrivalPort` varchar(20),
    `departureTime` timestamp
);

