-- 需求:
-- 1. 修改表结构，在部门表中添加部门简介字段
-- 2. 将李四的职称改为“工程师”,并将她的基本工资改成 2000，职务工资
-- 为 700
-- 3. 删除人事部门的部门记录
-- 4. 查询出每个雇员的雇员编号，实发工资，应发工资
-- 5. 查询姓张且年龄小于 40 的员工记录
-- 6. 查询雇员的雇员编号，姓名，职称，部门名称，实发工资
-- 7. 查询销售部门的雇员姓名，工资
-- 8. 统计各职称的人数
-- 9. 统计各部门的部门名称，实发工资总和，平均工资
-- 10. 查询比销售部门所有员工基本工资都高的雇员姓名

-- 1. 修改表结构，在部门表中添加部门简介字段
alter table department add departdesc varchar(50);

-- 2. 将李四的职称改为“工程师”,并将她的基本工资改成 2000，职务工资
-- 为 700
update employee e inner join salary s on e.empid=s.empid
set e.title='工程师',s.basesalary=2000,s.titlesalary=700
where e.name='李四';

-- 3. 删除人事部门的部门记录
delete from department where depname='人事部';

-- 4. 查询出每个雇员的雇员编号，实发工资，应发工资
select empid,basesalary+titlesalary-deduction '实发工资',basesalary '应发工资' from salary;

-- 5. 查询姓张且年龄小于 40 的员工记录
SELECT * FROM department d NATURAL LEFT JOIN employee e NATURAL LEFT JOIN salary WHERE (YEAR(CURDATE())-YEAR(e.birthday))<40;

-- 6. 查询雇员的雇员编号，姓名，职称，部门名称，实发工资
SELECT e.empid,e.name,e.title,d.depname,s.basesalary+s.titlesalary-s.deduction '实发工资' from employee e, department d, salary s
where e.empid =s.empid and d.depid=e.depid;

-- 7. 查询销售部门的雇员姓名，工资
select e.name,s.basesalary,s.titlesalary,s.deduction
from employee e,department d,salary s
where e.empid=s.empid and d.depid=e.depid and d.depname='销售部';

-- 8. 统计各职称的人数
SELECT title,COUNT(*) FROM employee GROUP BY title;

-- 9. 统计各部门的部门名称，实发工资总和，平均工资
SELECT d.depname,SUM(s.basesalary+s.titlesalary-s.deduction) '实发工资总和',AVG(s.basesalary+s.titlesalary-s.deduction) '平均工资'
FROM employee e,salary s,department d WHERE e.empid=s.empid AND e.depid=d.depid GROUP BY d.depname;

-- 10. 查询比销售部门所有员工基本工资都高的雇员姓名
SELECT e.name FROM employee e,salary s WHERE e.empid=s.empid AND s.basesalary>
(SELECT MAX(basesalary) FROM employee e,salary s,department d WHERE e.empid=s.empid AND e.depid=d.depid AND d.depname='销售部');


