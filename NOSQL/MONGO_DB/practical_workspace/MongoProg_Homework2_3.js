conn = new Mongo();
db = conn.getDB("students");


var studentsCursor = db.grades.find({"type":"homework"}).sort({"student_id":1});



if(studentsCursor.hasNext()){
		curStudent = studentsCursor.next();
		nextStudent = curStudent;
}


while(studentsCursor.hasNext()){

	curStudent =  studentsCursor.next();

	if(curStudent.student_id == nextStudent.student_id){
		if(curStudent.score < nextStudent.score){
			print(curStudent.score);
			db.grades.remove(curStudent);
		}else{
			print(nextStudent.score);
			db.grades.remove(nextStudent);
		}
		
	}
	else{

		nextStudent = curStudent;
	}
}
