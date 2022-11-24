INSERT INTO address (street, number, city)
VALUES ('street 1', '1', 'city 1');
INSERT INTO address (street, number, city)
VALUES ('street 2', '2', 'city 2');
INSERT INTO address (street, number, city)
VALUES ('street 3', '3', 'city 3');
INSERT INTO address (street, number, city)
VALUES ('street 4', '4', 'city 4');

INSERT INTO health_professional (name, specialty, address, roles, online_status, username, password)
VALUES ('PROFESSIONAL 1', 1, 1, 1, 0, 'professional1', 'admin');
INSERT INTO health_professional (name, specialty, address, roles, online_status, username, password)
VALUES ('PROFESSIONAL 2', 2, 2, 1, 0, 'professional2', 'admin');
INSERT INTO health_professional (name, specialty, address, roles, online_status, username, password)
VALUES ('PROFESSIONAL 3', 3, 3, 1, 1, 'professional3', 'admin');
INSERT INTO health_professional (name, specialty, address, roles, online_status, username, password)
VALUES ('PROFESSIONAL 4', 4, 4, 1, 1, 'professional4', 'admin');

INSERT INTO patient (name, total_appointment, address, roles, username, password)
VALUES ('PATIENT 1', 2, 1, 2, 'patient1', 'admin');
INSERT INTO patient (name, total_appointment, address, roles, username, password)
VALUES ('PATIENT 2', 1, 2, 2, 'patient2', 'admin');
INSERT INTO patient (name, total_appointment, address, roles, username, password)
VALUES ('PATIENT 3', 1, 3, 2, 'patient3', 'admin');
INSERT INTO patient (name, total_appointment, address, roles, username, password)
VALUES ('PATIENT 4', 1, 4, 2, 'patient4', 'admin');

INSERT INTO attendance (description, date, created, updated, health_professional, patient, attendance_status)
VALUES ('ATTENDANCE 1', '2022-11-22T10:00:00', '2022-11-22T10:00:00', '2022-11-22T10:00:00', 1, 1, 0);
INSERT INTO attendance (description, date, created, updated, health_professional, patient, attendance_status)
VALUES ('ATTENDANCE 2', '2022-11-22T15:20:00', '2022-11-22T10:00:00', '2022-11-22T10:00:00', 1, 1, 2);
INSERT INTO attendance (description, date, created, updated, health_professional, patient, attendance_status)
VALUES ('ATTENDANCE 3', '2022-11-22T15:00:00', '2022-11-22T10:00:00', '2022-11-22T10:00:00', 2, 2, 1);
INSERT INTO attendance (description, date, created, updated, health_professional, patient, attendance_status)
VALUES ('ATTENDANCE 4', '2022-11-22T14:00:00', '2022-11-22T10:00:00', '2022-11-22T10:00:00', 3, 3, 2);
INSERT INTO attendance (description, date, created, updated, health_professional, patient, attendance_status)
VALUES ('ATTENDANCE 5', '2022-11-22T16:00:00', '2022-11-22T10:00:00', '2022-11-22T10:00:00', 4, 4, 1);
