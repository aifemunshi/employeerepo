DROP TABLE IF EXISTS T_EMPLOYEE_DETAILS;  
CREATE TABLE T_EMPLOYEE_DETAILS (  
user_id VARCHAR2(50)  PRIMARY KEY,  
first_name VARCHAR2(50) NOT NULL, 
last_name VARCHAR2(50) NOT NULL,
mailid VARCHAR2(50) NOT NULL,
gender VARCHAR2(10) NOT NULL,
age NUMBER,
address VARCHAR2(100) NOT NULL
);

commit;