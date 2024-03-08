--  oracleXE -> username: system password: pgadmin5

create table accounts(id number(7) primary key, account_number number(7),name varchar(30),type varchar(20),mobile number(12),balance number(12),ifsc varchar(10),password varchar(20));
create table transactions(id number(7) primary key, from_account number(7), to_account number(7), ifsc varchar(10), amount number(12));