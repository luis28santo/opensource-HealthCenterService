-- INSERTS PARA TIPO_SALUD
INSERT INTO health_center_type (id, name) VALUES (1, 'Hospital');
INSERT INTO health_center_type (id, name) VALUES (2, 'Clinica');



-- INSERTS PARA CENTRO_SALUD

INSERT INTO health_center
(name, type_id, infrastructure_score, service_score, has_ambulance)
VALUES
('National Hospital Central', 1, 90, 85, true);

INSERT INTO health_center
(name, type_id, infrastructure_score, service_score, has_ambulance)
VALUES
('Miraflores Medical Clinic', 2, 70, 75, false);
