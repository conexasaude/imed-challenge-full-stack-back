INSERT INTO patient(id, username, password, total_appointments) VALUES (1, 'alesonbg', '123456', 0);
INSERT INTO patient(id, username, password, total_appointments) VALUES (2, 'gabriellebg', '123456', 0);
INSERT INTO patient(id, username, password, total_appointments) VALUES (3, 'test', '123456', 3);

INSERT INTO professional(id, name, status, rating, crm, password) VALUES (1, 'Drauzio Varela', 'AVAILABLE', 10, '000000-aa', '123456');
INSERT INTO professional(id, name, status, rating, crm, password) VALUES (2, 'Paulo Muzy', 'AVAILABLE', 10, '000000-aa', '123456');

INSERT INTO appointment(id, patient_id, professional_id, begining, ending) VALUES (1, 1, 1, '2022-11-28 09:00:00Z', '2022-11-28 09:30:00Z');