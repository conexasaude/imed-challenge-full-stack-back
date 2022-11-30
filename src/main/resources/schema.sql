CREATE TABLE IF NOT EXISTS patient(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username varchar(30) NOT NULL,
    password varchar(30) NOT NULL,
    total_appointments int NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS professional(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name varchar(100) NOT NULL,
    status varchar(100) NOT NULL,
    rating int NOT NULL,
    crm varchar(30) NOT NULL,
    password varchar(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS appointment(
    id bigint AUTO_INCREMENT PRIMARY KEY,
    patient_id bigint NOT NULL,
    professional_id bigint NOT NULL,
    begining TIMESTAMP NOT NULL,
    ending TIMESTAMP NOT NULL,
    FOREIGN KEY (professional_id) REFERENCES professional(id) ,
    FOREIGN KEY (patient_id) REFERENCES patient(id)
);

