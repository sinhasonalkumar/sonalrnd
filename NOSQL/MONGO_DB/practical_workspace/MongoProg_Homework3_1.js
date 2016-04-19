//db.students.update({"_id": 0},{$pull:{scores:{score:6.676176060654615}}})
con = new Mongo();
db = con.getDB("school");

var cur = db.students.find();
var curStudent;
var lowestHomeWorkScore;
var curScores;



while(cur.hasNext()){

	curStudent = cur.next();
	print(curStudent.name);
	
	var homeworkScore1;
	var homeworkScore2;
	curScores = curStudent.scores;

	count = 1;

	for(key in curScores){
		curScore = curScores[key];
		
		if("homework" == curScore.type){
			

			//print("**********")
			//print(curScore.score)
			//print("**********")

			if(count == 1){
				
				homeworkScore1 = curScore;	
			}

			if(count == 2){

				homeworkScore2 = curScore;	

				if(homeworkScore1.score < homeworkScore2.score){
					//print(homeworkScore1.score);

					db.students.update({"_id" :curStudent._id },  {"$pull": { "scores" : { "type" : "homework" , "score" : homeworkScore1.score} }})
				}else{
					//print(homeworkScore2.score);
					db.students.update({"_id" :curStudent._id },  {"$pull": { "scores" : { "type" : "homework" , "score" : homeworkScore2.score} }})
				}
			}

			
			count++;
			
		}
	}

	print("-------------------------")

}

