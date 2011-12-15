function (doc) {
	if (doc._id.substr(0, 5) === "week_"){
		emit(doc._id.substr(5),{
			"week": doc.week,
			"practiceC": doc.practiceC,
			"prname": doc.prname,
			"timesig": doc.timesig,
			"BPMs": doc.BPMs,
			"favorite": doc.favorite,
			"date": doc.date,
			"Notes": doc.Notes
		});
	}
};