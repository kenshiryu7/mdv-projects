$('#home').live("pageshow", function(){
	$.couch.db("asdproject").view("app/weeks",{
		success: function(data){
			//console.log(data);
			$('#couch').empty();
			$.each(data.rows, function(index, weeks){
				var item = (weeks.value || weeks.doc);
				//console.log(item);
				$('#couch').append(
						$('<li>').append(
								$('<a>')
								//going to change from item.weeks to go to date
									.attr("href", "weeks.html?week=" + item.date)
									.text(item.week)
						)
				);
			});
			$('#couch').listview('refresh');
		}
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
	

	
function editItem(id) {
	    
	    var value = localStorage.getItem(id);
	    var itemId = id;
	    
	    value = value.split(";");
	    var practiceC   = value[0];
	    var prname      = value[1];
	    var timesig     = value[2];
	    var BPMs        = value[3];
	    var favorite    = value[4];
	    var date        = value[5];
	    var Notes       = value[6];
	    
	    //populates form fields with current localStorage values
	    $('#practiceC').val(practiceC);
	    $('#prname').val(prname);
	    $('#timesig').val(timesig);
	    $('#BPMs').val(BPMs);
	    if (favorite =="on") {
	        $('#favorite').attr("checked", "checked");
	    }
	    $('#date').val(date);
	    $('#Notes').val(Notes);
	    
	    //reveal editItems button, hide submit button
	    var editItem = $('#editItem').show();
	    
	    var submit = $('#sdata').show();
	    
	    //capture editItem button's click
	    $('#editItem').click() = function () {
	        
	        var practiceC       = $('#practiceC').val();
	        var prname          = $('#prname').val();
	        var timesig         = $('#timesig').val();
	        var BPMs            = $('#BPMs').val();
	        var favorite        = $('#favorite').val();
	        var date            = $('#date').val();
	        var Notes           = $('#Notes').val();
	        var allItems        = [
	            practiceC,
	            prname,
	            timesig,
	            BPMs,
	            favorite,
	            date,
	            Notes
	        ];
	        if ( practiceC != "" && prname != "" && timesig != ""){
	            localStorage.setItem(itemId, allItems.join(";"));
	            alert("Updated Practice Log");
	        } else {
	            alert("please fill required fields.");
	        }
	    };
	    
} //editItem	
	
	//Delete single Items

	function deleteItem(id) {
	    var ask = confirm("Are you sure?");
	    if (ask) {
	        localStorage.removeItem(id);
	        window.location.reload();
	    } else {
	        alert("Item not removed!");
	    }
	}


	//Delete all Items

    function clearLocal() {
	    localStorage.clear();
	    $('#clear').css('display', 'none');

	    return false;
    }
});
});