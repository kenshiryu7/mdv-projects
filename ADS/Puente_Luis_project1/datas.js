//

$.ready(function(){
	    
	    $.ajax({
		"url": 'xhr/json.php',
		"type": 'GET',
		"dataType":'json',
		"success":function(response) {
		    console.log($.parseJSON(response));
		}
	    });
	    
});