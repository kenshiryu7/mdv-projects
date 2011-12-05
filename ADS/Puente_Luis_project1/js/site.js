$(function(){
    
var anchorTags = $('#clear a');


//validate form function. Would like to add regEXp for possibly the date varif.

function validateForm() {
    var selectPraC = document.forms[0]["practiceC"].value;
    if (selectPraC =="") {
        alert("Please select practice Category");
        $('#practiceC').css({
            border: '1px solid red'
        });
        return false;
    } else {
        $('#practiceC').css({
            border: "1px solid 9BC4E2"
        });
    }
    var practiceName = document.forms[0]["prname"].value;
    if (practiceName =="") {
        alert("Please Select a Practice Name");
        $('#prname').css({
            border: "1px solid red"
        });
        return false;
    } else {
        $('#prname').css({
            border: "1px solid 9BC4E2"
        });
    }
    
    var timeSignature = document.forms[0]["timesig"].value;
    if (timeSignature =="") {
        alert("Please select a time signature");
        $('#timesig').css({
            border: "1px solid red"
        });
        return false;
    } else {
        $('#timesig').css({
            border: "1px solid 9BC4E2"
        });
    }
    
    var practiceDate = document.forms[0]["date"].value;
    if (practiceDate =="") {
        alert("Please input next practice date");
        $('#date').css({
            border: "1px solid red"
        });
        return false;
    } else {
        $('#date').css({
            border: "1px solid 9BC4E2"
        });
    }
    
    alert("Data Saved!");
    saveItems();
}




function getItems() {
  
   var getListdiv = $('#new');
   
   for (var i = 0, len = localStorage.length; i < len; i++) {
        var key = localStorage.key(i);
        var value = localStorage.getItem(key);
        value = value.split(";");
        var practiceC   =value[0];
        var prname      =value[1];
        var timesig     =value[2];
        var BPMs        =value[3];
        var favorite    =value[4];
        var date        =value[5];
        var Notes       =value[6];
        var newDiv = $("<div>");
        for (var k = 0, allLength = value.length; k < allLength; k++) {
            var newPara = $("<p/>");
            var itemTxt = $('value[k]').text();
            newPara.appendTo(itemTxt);
            newDiv.appendTo(newPara);
            getListdiv.appendTo(newDiv);
        }
   
       //attemp to adding images per category
        var image ="";
            if (practiceC =="") {image ="";}
            if ((practiceC =="Hands") || (practiceC =="Feet") || (practiceC =="Drumset")) {image ="Rudiments.png";}
            if ((practiceC =="Feet/Hands") || (practiceC =="Hands/Feet")) {image = "Ostinatos.png";}
            if ((practiceC =="Jazz") || (practiceC =="Rock") || (practiceC =="Funk")) {image ="beats.png";}
        
     
         //add images   
        var newImg = $("<img/>");
        var setSrc = newImg.attr("src","img/" + image);
        getListdiv.appendTo(newImg);
       
      
   //add delete single item link
   var deleteLink = $("<a/>");
   var setHref    = deleteLink.attr("href", "#");
   var setOnclick = deleteLink.attr("onclick", "deleteItem(" + key + ");");
   var deleteText = $("delete item").text();
   deleteLink.appendTo(deleteText);
   newDiv.appendTo(deleteLink);
   
   //add edit single item
   var editLink         = $("<a/>");
   var setEditHref      = editLink.attr("href", "#");
   var setEditOnclick   = editLink.attr("onclick", "editItem(" + key + ");");
   var editText         = $("edit item").text();
   editLink.appendTo(editText);
   newDiv.appendTo(editLink);
   }
 
    if(localStorage.length >=1) {
        var clearLink = $('#clear').show();
        
        
   
    } else {
            var  prname    = "enter practice name";
            var  timesig   = "enter a time signature";
            var  BPMs      = "enter a BPM's"
            
           $('#prname').val(prname);
           $('#timesig').val(timesig); 
           $('#BPMs').val(BPMs);
        }
}


//save items function. get date and time from comp...
function saveItems(id) {
    var d = new Date();
    var key = (d.getTime());
    var practiceC = $('#practiceC').val();
    var prname    = $('#prname').val();
    var timesig   = $('#timesig').val();
    var BPMs      = $('#BPMs').val();
    var favorite  = $('#favorite').val();
    var date      = $('#date').val();
    var Notes     = $('#Notes').val();
    
    var allItems  = [
            practiceC,
            prname,
            timesig,
            BPMs,
            favorite,
            date,
            Notes
        ];
    localStorage.setItem(key, allItems.join(";"));
}


function storeData(id) {
    var practiceC    = $('#practiceC').val();
    var prname       = $('#prname').val();
    var timesig      = $('#timesig').val();
    var BPMs         = $('#BPMs').val();
    var favorite     = $('#favorite').val();
    var date         = $('#date').val();
    var Notes        = $('#Notes').val();
    
    localStorage.setItem("apppracticeC", practiceC);
    localStorage.setItem("appprname", prname);
    localStorage.setItem("apptimesig", timesig);
    localStorage.setItem("appBPMs", BPMs);
    localStorage.setItem("appfavorite", favorite);
    localStorage.setItem("appdate", date);
    localStorage.setItem("appNotes", Notes);
}


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

//functions to Attempt Data parse into form fields


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