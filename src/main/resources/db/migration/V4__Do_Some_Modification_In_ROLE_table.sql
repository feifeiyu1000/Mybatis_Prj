ALTER TABLE ROLE
CHANGE name role_name VARCHAR(20);

-- INSERT SOME VALUES IN USER TABLE
INSERT INTO USER (name,username,password,enabled)
VALUES('marouane','mar1','ma1$@',1),
  ('ayoub','ay1','ma1$@',1),
  ('chaime','ch1','ma1$@',1);

-- INSERT SOME VALUES TO ROLE TABLE
INSERT INTO ROLE (role_name,user_id)
VALUES ('ADMIN',1),
  ('USER',2),
  ('USER',3);