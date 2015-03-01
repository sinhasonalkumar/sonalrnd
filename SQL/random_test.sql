-- Question : I have three tables  student, class and student_class. I want all class and total student in that class.

select c.name from class c left outer join student_class sc on c.class_id = sc.class_id  group by c.name;


select c.name, count(s.name) as StudentCount from class c left outer join student_class sc on c.class_id = sc.class_id inner join student s on s.student_id = sc.student_id group by c.name;

select c.name, count(s.name) as StudentCount from class c left outer join student_class sc on c.class_id = sc.class_id left outer join student s on s.student_id = sc.student_id group by c.name;

select c.name, count(s.name) as StudentCount from class c left outer join student_class sc on c.class_id = sc.class_id left outer join student s on s.student_id = sc.student_id group by c.name limit 2;

explain select c.name, count(s.name) as StudentCount from class c left outer join student_class sc on c.class_id = sc.class_id left outer join student s on s.student_id = sc.student_id group by c.name;