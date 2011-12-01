//
//Json data function

$(function(){
	    
	    $.ajax({
		"url": 'xhr/json.json',
		"type": 'GET',
		"dataType":'json',
		"success":function(response) {
		    console.log(response);
		}
	    });
            
});

//XML data function

$(function(){
	    
	    $.ajax({
		"url": 'xhr/xml.php',
		"type": 'GET',
		"dataType":'xml',
		"success":function(response) {
		    console.log(response);
		}
	    });
            
});

//CSV data function

$(function(){
	    
	    $.ajax({
		"url": 'xhr/csv.php',
		"type": 'GET',
		"dataType":'csv',
		"success":function(response) {
		    console.log(response);
		}
	    });
            
});