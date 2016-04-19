use rop

print("before deletion :: " + db.images.find({"tags":"sunrises"}).count());

db.albumss.ensureIndex({"images":1});

var cur = db.images.find();

var docRemovedCount = 0;

while(cur.hasNext()){
	doc=cur.next();
	image_id=doc._id

	count=db.albums.find({"images":image_id}).count();
	if(count == 0){
		db.images.remove({"_id":image_id});
		docRemovedCount++;
	}
}

print("Total Documents Removed :: " + docRemovedCount);

print("after deletion :: " + db.images.find({"tags":"sunrises"}).count());