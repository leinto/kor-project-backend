use kor;


-- select * from resources;


select * from resources r join resource_projects rp on r.id = rp.resource_id
join projects p on rp.project_id = p.id;

select * from roles

select * from projects

select * from attributes;

select * from resources;

delete from attributes where name="x"

delete from resources where id between 35 and 36;

delete from users where id between 3 and 13;


select * from project_resources;

insert into project_resources values 
(1, 5), 
(1, 6), 
(1, 7), 
(1, 8), 
(1, 9), 
(1, 11), 
(1, 12), 
(1, 13), 
(1, 14), 
(1, 15), 
(1, 16), 
(1, 17), 
(1, 18),
(1, 21),  
(1, 22),  
(1, 23),  
(1, 24),  
(1, 25),  
(1, 26);

insert into project_resources values
(2, 6), 
(2, 7), 
(2, 8), 
(2, 9), 
(2, 11), 
(2, 12), 
(2, 13), 
(2, 14), 
(2, 15), 
(2, 16), 
(2, 17), 
(2, 18),
(2, 21),  
(2, 22),  
(2, 23),  
(2, 24),  
(2, 25),  
(2, 26) 
