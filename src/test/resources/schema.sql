CREATE TABLE IF NOT EXISTS DEPT (
	DEPTNO NUMBER(2) NOT NULL,
	DNAME VARCHAR2(14),
	LOC VARCHAR2(13),
	PRIMARY KEY (DEPTNO)
);

CREATE TABLE IF NOT EXISTS EMP (
	EMPNO NUMBER(4) NOT NULL,
	ENAME VARCHAR2(10),
	JOB VARCHAR2(9),
	MGR NUMBER(4),
	HIREDATE DATE,
	SAL NUMBER(7,2),
	COMM NUMBER(7,2),
	DEPTNO NUMBER(2),
	PRIMARY KEY (EMPNO)
);