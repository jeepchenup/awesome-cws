SELECT * FROM department_manager;

--department_employee 表
SELECT * FROM department_employee ORDER BY emp_no ASC, from_date ASC;

--select all departments info by employee id
SELECT d.dept_no, d.dept_name
FROM department_employee de, department d, employee e
WHERE 
	de.dept_no = d.dept_no 
	AND
	de.emp_no = e.emp_no
	AND
	e.emp_no = ?;