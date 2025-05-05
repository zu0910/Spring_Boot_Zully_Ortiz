
use jpademo;
insert into roles(id, name) values 
(1, 'User'),
(2, 'Admin'),
(3, 'Estudiante');

insert into person(id, rol_id, full_name, last_name, programming_languaje) values
(1, 1, 'valentina', 'molina', 'java'),
(2, 2, 'laura', 'lopez', 'html'),
(3, 3, 'cristian', 'jaimes', 'css');

INSERT INTO passport(expiration, id, person_id, number) VALUES
('2026-02-06', 1,1, 'NUM123'),
('2021-04-08', 2,2, 'NUM456'),
('2025-08-09', 3,3, 'NUM789');

insert into project(id, name)values
(1, 'tecn'),
(2, 'digi'),
(3, 'desa');

insert into persons_projects(person_id, projects_id)values
(1,1),
(2,2),
(3,3);