$(function(){
//Json data function

function getJson(){
	    
	    $.ajax({
		"url": 'xhr/json.json',
		"type": 'GET',
		"dataType":'json',
		"success":function(data, response) {
                    alert("JSON data loaded.");
		    console.log(response);
		}
	    });
            
}

//XML data function

function getXML(){
	    
	    $.ajax({
		"url": 'xhr/xml.xml',
		"type": 'GET',
		"dataType":'xml',
		"success":function(data, response) {
                    alert("XML data loaded");
		    console.log(response);
                    $(data).find('items').each(function(){
                        
                    });
		}
	    });
            
}

//CSV data function

function getCSV(){
	    
	    $.ajax({
		"url": 'xhr/csv.csv',
		"type": 'GET',
		"dataType":'csv',
		"success":function(data, response) {
                    alert("CSV data loaded");
		    console.log(response);
		}
	    });
}

$("#jsonB").bind("click", getJson);
$("#xmlB").bind("click", getXML);
$("#csvB").bind("click", getCSV);

});