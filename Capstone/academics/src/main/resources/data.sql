-- ROLES
INSERT INTO role(name) VALUES ('STUDENT');
INSERT INTO role(name) VALUES ('FACULTY');
INSERT INTO role(name) VALUES ('ADMIN');

-- USERS (password = 1234)
INSERT INTO user(name,email,password,role_id)
VALUES ('Student One','student@gmail.com','{noop}1234',1);

INSERT INTO user(name,email,password,role_id)
VALUES ('Faculty One','faculty@gmail.com','{noop}1234',2);

INSERT INTO user(name,email,password,role_id)
VALUES ('Admin One','admin@gmail.com','{noop}1234',3);
