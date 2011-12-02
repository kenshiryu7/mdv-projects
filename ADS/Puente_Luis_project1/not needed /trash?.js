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



//xml

<script type="text/javascript">
	    $(function() {
		
		function openXml(){
		    $.ajax({
			url: "xhr/xml.php",
			type: "GET",
			dataType: "xml",
			success: function(xml, response) {
			    console.log(response);
				$(xml).find('item').each(function(){
				    var id = $(this).find('context').text();
				    var context = $(this).find('context').text();

				   // $('<div class="items" id="xlink'+id+'"></div>').html('Context: '+context).appendTo('#page');
				    //$(this).find('detail').each(function(){
					var practiceC   = $(this).find('practiceC').text();
					var prname 	= $(this).find('prname').text();
					var timesig 	= $(this).find('timesig').text();
					var bpms 	= $(this).find('bpms').text();
					var favorite 	= $(this).find('favorite').text();
					var date 	= $(this).find('date').text();
					var notes       = $(this).find('notes').text();
					
					$('<div class=""></div>').html("Practice Cat: " + practiceC).appendTo('#xlink' +id);
					$('<div class=""></div>').html("Practice name: " + prname).appendTo('#xlink' +id);
					$('<div class=""></div>').html("Time Sig: " + timesig).appendTo('#xlink' +id);
					$('<div class=""></div>').html("BPMs: " + bpms).appendTo('#xlink' +id);
					$('<div class=""></div>').html("Favorite: " + favorite).appendTo('#xlink' +id);
					$('<div class=""></div>').html("Date: " + date).appendTo('#xlink' +id);
					$('<div class=""></div>').html("Notes: " + notes).appendTo('#xlink' +id);

				    });
				});
			}
		    });
		}
		$('.xml').bind('click', openXml);  
	    });
	</script>