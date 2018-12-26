INSERT INTO employee(emp_no, first_name, last_name, birth_date, gender, hire_date) SELECT emp_no, first_name, last_name, birth_date, gender, hire_date FROM employees.employees;
INSERT INTO department(dept_no, dept_name) SELECT dept_no, dept_name FROM employees.departments;
INSERT INTO title(emp_no, title, from_date, to_date) SELECT emp_no, title, from_date, to_date FROM employees.titles;
INSERT INTO salary(emp_no, from_date, salary, to_date) SELECT emp_no, from_date, salary, to_date FROM employees.salaries;
--INSERT INTO department_employee SELECT * FROM employees.dept_emp;
--INSERT INTO department_manager SELECT * FROM employees.dept_manager;