//

$(document).ready(function(){
	    
	    /*$.ajax({
		"url": 'xhr/json.json',
		"type": 'GET',
		"dataType":'json',
		"success":function(response) {
		    console.log(response);
		}
	    });
            */
            $.getJSON('xhr/json.json', function(response){console.log(response);});
});