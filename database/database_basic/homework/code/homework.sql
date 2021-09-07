# grade 表增加一个阶段，“就业期”
insert into grade(gradeid,gname) values(1,'就业期');
# 将第三阶段的学生的 gradeid 改为就业期的 id
update student set gid=1 where gid=3;
# 1.查询所有得了 100 分的学号
select stuno from score where score=100;
# 2.查询所有 1989 年出生的学生（1989-1-1~1990-1-1）
select * from student where birthday between '1989-1-1' and '1990-1-1';
# 3.查询学生姓名为“金蝶”的全部信息
select * from student where stuname = '金蝶';
# 4.查询 subjectid 为 8 的科目考试未及格（60 分）的学号和成绩
select stuno,score from score where subjectid=8 and score<60;
# 5.查询第 3 阶段课时大于 50 的课程全部信息
select * from subject where gradeid=(select gradeid from grade where gname='第三阶段') and studycount>50;
# 6.查询 S1101001 学生的考试信息
select * from score where stuno='S1101001';
# 7.查询所有第二阶段的女生信息
select * from student where sex='女' and gid=(select gradeid from grade where gname='第二阶段');
# 8.“基于.NET 平台的软件系统分层开发”需要多少课时
select studycount from subject where subjectname='基于.NET 平台的软件系统分层开发';
# 9.查询“设计 MySchool 数据库”和“面向对象程序设计”的课时(使用 in)
select studycount from subject where subjectname in('设计 MySchool 数据库','面向对象程序设计');
# 10.查询所有地址在山东的学生信息
select * from student where address like '%山东%';
# 11. 查询所有姓凌的单名同学
select * from student where stuname like '凌_';
# 12.查询 gradeid 为 1 的学生信息，按出生日期升序排序
select * from student where gid=1 order by birthday;
# 13.查询 subjectid 为 3 的考试的成绩信息，用降序排序
select * from score  where subjectid=3 order by score desc;
# 14.查询 gradeid 为 2 的课程中课时最多的课程信息
select * from subject where gradeid=2 order by studycount desc limit 0,1;
# 15.查询北京的学生有多少个
select count(*) from student where address like '%北京%';
# 16.查询有多少个科目学时小于50
select count(*) from subject where studycount<50;
# 17.查询 gradeid 为 2 的阶段总课时是多少
select sum(studycount) from subject where gradeid=2;
# 18.查询 subjectid 为 8 的课程学生平均分
select avg(score) from score where subjectid=8;
# 19.查询 gradeid 为 3 的课程中最多的学时和最少的学时
select max(studycount),min(studycount) from subject where gradeid=3;
# 20.查询每个科目有多少人次考试
select subjectid,count(*) from score
group by subjectid;
# 21.每个阶段课程的平均课时
select gradeid,avg(studycount) from subject group by gradeid;

# 22.查询每个阶段的男生和女生个数（group by 两列）
select gid,sex,count(*) from student group by gid,sex;
