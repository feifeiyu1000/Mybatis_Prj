ALTER TABLE ROLE
CHANGE name role_name VARCHAR(20);

-- INSERT SOME VALUES IN USER TABLE
INSERT INTO USER (name,username,password,enabled)
VALUES('marouane','mar1','ma1$@',1),
  ('ayoub','ay1','ma1$@',1),
  ('chaime','ch1','ma1$@',1),
  ('rodwil', 'rod', '$2a$10$75pBjapg4Nl8Pzd.3JRnUe7PDJmk9qBGwNEJDAlA3V.dEJxcDKn5O', 1);


-- INSERT SOME VALUES TO ROLE TABLE
INSERT INTO ROLE (role_name,user_id)
VALUES ('ROLE_ADMIN',1),
  ('ROLE_USER',2),
  ('ROLE_USER',3),
  ('ROLE_ADMIN',4);