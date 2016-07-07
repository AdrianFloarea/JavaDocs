CREATE USER AdrianFloarea IDENTIFIED BY AdrianFloarea; -- you should replace my user name with yours. â€œIDENTIFIED BYâ€? means the password.
GRANT CREATE SESSION TO AdrianFloarea; -- necessary for connecting to the database with your new user.
GRANT CREATE ANY INDEX TO AdrianFloarea; -- we use indexes for faster queries.
GRANT ALTER ANY INDEX TO AdrianFloarea;
GRANT DROP ANY INDEX TO AdrianFloarea;
GRANT CREATE ANY PROCEDURE TO AdrianFloarea; -- we will use them in following workshops.
GRANT ALTER ANY PROCEDURE TO AdrianFloarea;
GRANT DROP ANY PROCEDURE TO AdrianFloarea;
GRANT EXECUTE ANY PROCEDURE TO AdrianFloarea;
GRANT CREATE ANY SEQUENCE TO AdrianFloarea; -- we need sequences for inserting data.
GRANT ALTER ANY SEQUENCE TO AdrianFloarea;
GRANT DROP ANY SEQUENCE TO AdrianFloarea;
GRANT SELECT ANY SEQUENCE TO AdrianFloarea;
GRANT CREATE ANY TABLE TO AdrianFloarea;
GRANT ALTER ANY TABLE TO AdrianFloarea;
GRANT DELETE ANY TABLE TO AdrianFloarea;
GRANT DROP ANY TABLE TO AdrianFloarea;
GRANT INSERT ANY TABLE TO AdrianFloarea;
GRANT LOCK ANY TABLE TO AdrianFloarea;
GRANT SELECT ANY TABLE TO AdrianFloarea;
GRANT UPDATE ANY TABLE TO AdrianFloarea;
GRANT CREATE TABLESPACE TO AdrianFloarea;
GRANT ALTER TABLESPACE TO AdrianFloarea;
GRANT DROP TABLESPACE TO AdrianFloarea;
GRANT CREATE ANY VIEW TO AdrianFloarea;
GRANT DROP ANY VIEW TO AdrianFloarea;
GRANT UNDER ANY VIEW TO AdrianFloarea;
alter user AdrianFloarea quota 50m on system;
