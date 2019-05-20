drop database kor;
create database kor;
SET GLOBAL time_zone = '+8:00';
use kor;
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_PM');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
alter table resources modify attributes text;


INSERT INTO projects VALUES('1','Comedy');
INSERT INTO projects VALUES('2','Musical');

use kor;
insert into attributes values
(1, 'resourceName'), 
(2, 'resourceCode');

use kor;
insert into project_resources(project_id, resource_id) values
(1, 1),
(1, 2),
(1, 4),
(2, 2),
(2, 3),
(2, 4);

insert into attributes values (3, 'price')

