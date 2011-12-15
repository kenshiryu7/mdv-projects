$('#home').live("pageshow", function(){
	$.couch.db("asdproject").view("app/weeks",{
		success: function(data){
			//console.log(data);
			$('#couch').empty();
			$.each(data.rows, function(index, weeks){
				var item = (weeks.value || weeks.doc);
				$('#couch').append(
						$('<li>').append(
								$('<a>')
								//going to change from item.weeks to go to date
									.attr("href", "weeks.html?date=" + item.prname)
									.text(item.date)
						)
				);
			});
			$('#couch').listview('refresh');
		}
	});
});
var urlVars = function(urlData) {
	var urlData = $($.mobile.activePage).data("url");
	var urlParts = urlData.split('?');
	var urlPairs = urlParts[1].split('&');
	var urlValues = {};
	for(var pair in urlPairs){
		var keyValue = urlPairs[pair].split('=');
		var key = decodeURIComponent(keyValue[0]);
		var value = decodeURIComponent(keyValue[1]);
		urlValues[key] = value;
	}
	return urlValues;
};	
//console.log(urlValues);

$('#date').live("pageshow", function(){
	var date = urlVars()["date"];
	console.log(date);
});