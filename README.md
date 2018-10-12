# RMS Study Case
What this task try to achieve:
1. Implement Spring MVC
2. Implement CRUD operation Hibernate
3. Implement spring security
4. Create Fatjar

requirements
MySQL (change the connection properties in application.properties)

initial data:
- INSERT INTO `role` (id, name) VALUES(1, 'ADMIN');
- INSERT INTO `role` (id, name) VALUES(2, 'USER');
- INSERT INTO privilege (id, name) VALUES(1, 'WRITE_PRIVILEGE');
- INSERT INTO privilege (id, name) VALUES(2, 'READ_PRIVILEGE');
- INSERT INTO role_privilege (role_id, privilege_id) VALUES(1, 1);
- INSERT INTO role_privilege (role_id, privilege_id) VALUES(1, 2);
- INSERT INTO role_privilege (role_id, privilege_id) VALUES(2, 2);


# TO DO
Create some setup data automatically when the program is ran for the first time.
