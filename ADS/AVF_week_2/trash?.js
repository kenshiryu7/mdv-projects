$(function() {
	    $.ajaxSetup({
		cache: false
	    });
	    function jsonData() {
		$.ajax({
		    url: 'data.json',
		    type: 'GET',
		    dataType: 'json',
		    error: 'where's the JSON?',
		    success: function(data,response){
			//console.log(response);
			//var item i, j, id;
			for (i=0, j=data.item.length; i < j; i++) {
			    //id = i + 1;
			    item = data.item[i];
			    
			    var text = ('Context: ' + item.context);				
			    $('<div class="practiceC" id="jsonitem_'+id+'"></div>').html(contextTxt).appendTo('.data_load');			
			    
			    $('<div class="prname"></div>').html("Name: " + item.name).appendTo('.data_load');
			    $('<div class="timesig"></div>').html("Priority: " + item.priority).appendTo('.data_load');
			    $('<div class="BPMs"></div>').html("Favorite: " + item.favorite).appendTo('.data_load');
			    $('<div class="favorite"></div>').html("Start Date: " + item.sDate).appendTo('.data_load');
			    $('<div class="date"></div>').html("End Date: " + item.eDate).appendTo('.data_load');
			    $('<div class="Notes"></div>').html("Due Date: " + item.DDate).appendTo('.data_load');
			}
		    }
		});
	    }
	  });  