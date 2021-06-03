-- view
create or replace view vw_full_employee
as
select e.EMP_NO
	, e.EMP_NAME
	, t.TITLE_NO as TITLE_NO
	, t.TITLE_NAME as TITLE_NAME
	, e.MANAGER as MANAGER_NO
	, m.EMP_NAME as MANAGER_NAME
	, e.SALARY
	, d.DEPT_NO
	, d.DEPT_NAME
	, d.FLOOR
	from employee e join title t on e.TNO = t.TITLE_NO
		left join employee m on e.MANAGER = m.EMP_NO
		join department d on e.DNO = d.DEPT_NO ;
