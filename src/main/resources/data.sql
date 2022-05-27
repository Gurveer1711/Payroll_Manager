insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Jon', '$2a$10$X3lXE3agJPsCAca/plgJaeRYVm9VSsngpcksNA/qF7o488vmqvpr6', 1);
 
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('employee', '$2a$10$X3lXE3agJPsCAca/plgJaeRYVm9VSsngpcksNA/qF7o488vmqvpr6', 1);

insert into sec_role (roleName)
values ('ROLE_OWNER');

insert into sec_role (roleName)
values ('ROLE_EMPLOYEE');
 
insert into user_role (userId, roleId)
values (1, 1);
 
insert into user_role (userId, roleId)
values (2, 2);

insert into employees (name,emp_id,su_hr,mo_hr,tu_hr,we_hr,th_hr,fr_hr,sa_hr,wage) values('Ram', '123', 8, 5, 6, 7,8,7,6, 56);
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Ram', '$2a$10$X3lXE3agJPsCAca/plgJaeRYVm9VSsngpcksNA/qF7o488vmqvpr6', 1);
insert into user_role (userId, roleId)
values (3, 2);

insert into employees (name,emp_id,su_hr,mo_hr,tu_hr,we_hr,th_hr,fr_hr,sa_hr,wage) values('Vishnu', '123', 8, 5, 6, 7,8,7,6, 56);
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Vishnu', '$2a$10$X3lXE3agJPsCAca/plgJaeRYVm9VSsngpcksNA/qF7o488vmqvpr6', 1);
insert into user_role (userId, roleId)
values (4, 2);

insert into employees (name,emp_id,su_hr,mo_hr,tu_hr,we_hr,th_hr,fr_hr,sa_hr,wage) values('Alex', '123', 8, 5, 6, 5,8,7,6, 28);
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Alex', '$2a$10$X3lXE3agJPsCAca/plgJaeRYVm9VSsngpcksNA/qF7o488vmqvpr6', 1);
insert into user_role (userId, roleId)
values (5, 2);

insert into employees (name,emp_id,su_hr,mo_hr,tu_hr,we_hr,th_hr,fr_hr,sa_hr,wage) values('Richard', '123', 1, 5, 6, 7,8,7,6, 25);
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Richard', '$2a$10$X3lXE3agJPsCAca/plgJaeRYVm9VSsngpcksNA/qF7o488vmqvpr6', 1);
insert into user_role (userId, roleId)
values (6, 2);

insert into employees (name,emp_id,su_hr,mo_hr,tu_hr,we_hr,th_hr,fr_hr,sa_hr,wage) values('Rocket', '123', 8, 5, 5, 7,3,7,6, 32);
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Rocket', '$2a$10$X3lXE3agJPsCAca/plgJaeRYVm9VSsngpcksNA/qF7o488vmqvpr6', 1);
insert into user_role (userId, roleId)
values (7, 2);

insert into employees (name,emp_id,su_hr,mo_hr,tu_hr,we_hr,th_hr,fr_hr,sa_hr,wage) values('Leo', '123', 5, 2, 6, 7,2,7,6, 18);
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Leo', '$2a$10$X3lXE3agJPsCAca/plgJaeRYVm9VSsngpcksNA/qF7o488vmqvpr6', 1);
insert into user_role (userId, roleId)
values (8, 2);

insert into employees (name,emp_id,su_hr,mo_hr,tu_hr,we_hr,th_hr,fr_hr,sa_hr,wage) values('Bro', '123', 6, 5, 6, 7,3,7,1, 16);
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Bro', '$2a$10$X3lXE3agJPsCAca/plgJaeRYVm9VSsngpcksNA/qF7o488vmqvpr6', 1);
insert into user_role (userId, roleId)
values (9, 2);

insert into employees (name,emp_id,su_hr,mo_hr,tu_hr,we_hr,th_hr,fr_hr,sa_hr,wage) values('Richmond', '123', 5, 5, 1, 7,8,7,6, 44);
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Richmond', '$2a$10$X3lXE3agJPsCAca/plgJaeRYVm9VSsngpcksNA/qF7o488vmqvpr6', 1);
insert into user_role (userId, roleId)
values (10, 2);

insert into employees (name,emp_id,su_hr,mo_hr,tu_hr,we_hr,th_hr,fr_hr,sa_hr,wage) values('Gurpreet', '123', 1, 1, 6, 7,8,7,6, 20);
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Gurpreet', '$2a$10$X3lXE3agJPsCAca/plgJaeRYVm9VSsngpcksNA/qF7o488vmqvpr6', 1);
insert into user_role (userId, roleId)
values (11, 2);

insert into employees (name,emp_id,su_hr,mo_hr,tu_hr,we_hr,th_hr,fr_hr,sa_hr,wage) values('Ruby', '123', 4, 3, 6, 5,2,7,6, 23);
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Ruby', '$2a$10$X3lXE3agJPsCAca/plgJaeRYVm9VSsngpcksNA/qF7o488vmqvpr6', 1);
insert into user_role (userId, roleId)
values (12, 2);
