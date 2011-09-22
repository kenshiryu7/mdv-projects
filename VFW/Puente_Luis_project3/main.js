//Luis Puente
//local storage

var clearLink = document.getElementById("clear");
var anchorTags = clearLink.getElementsByTagName("a");


//validate form function. Would like to add regEXp for possibly the date varif.

function validateForm() {
    var selectPraC = document.forms[0]["practiceC"].value;
    if (selectPraC =="") {
        alert("Please select practice Category");
        document.getElementById("practiceC").style.border = "1px solid red";
        return false;
    } else {
        document.getElementById("practiceC").style.border = "1px solid 9BC4E2";
    }
    var practiceName = document.forms[0]["prname"].value;
    if (practiceName =="") {
        alert("Please Select a Practice Name");
        document.getElementById("prname").style.border = "1px solid red";
        return false;
    } else {
        document.getElementById("prname").style.border = "1px solid 9BC4E2";
    }
    
    var timeSignature = document.forms[0]["timesig"].value;
    if (timeSignature =="") {
        alert("Please select a time signature");
        document.getElementById("timesig").style.border = "1px solid red";
        return false;
    } else {
        document.getElementById("timesig").style.border = "1px solid 9BC4E2";
    }
    
    var practiceDate = document.forms[0]["date"].value;
    if (practiceDate =="") {
        alert("Please input next practice date");
        document.getElementById("date").style.border = "1px solid red";
        return false;
    } else {
        document.getElementById("date").style.border = "1px solid 9BC4E2";
    }
    
    alert("Data Saved!");
    storeData();
}

//make practice categories dynamically. help for images?

/*var praCat = ["", "Rudiments", "Beats", "Ostinatos"],
    
    formTag     = document.getElementsByTagName("form"),
    makePara    = document.createElement("p"),
    makeSelect  = document.createElement("select")
;

makeSelect.setAttribute("id", "praCat");

var makePraCat = function (name) {
    for( var i=0, j=praCat.length; i < j; i++) {
        var makeOpt = document.createElement("option");
        var optText = document.createTextNode(praCat[i]);
        makeOpt.setAttribute("value", praCat[i]);
        makeOpt.appendChild(optText);
        makeSelect.appendChild(makeOpt);
    };
    makePara.appendChild(makeSelect);
    var getUl = formTag[0].firstChild;
    var paraSelect = formTag[0].insertBefore(makePara, getUl);
};

makePraCat();*/

/*
function pCatArray() {
    var rudiments = ["hands", "feet", "Drumset"];
    var beats     = ["Jazz","Rock", "Funk"];
    var ostinatos = ["Feet/Hands","Hands/Feet"];
    var category = rudiments, beats, ostinatos;
    for (var i=0, j=category.length; i < j; i++) {
        var makeOptionGroup = document.createElement("optgroup");
        for(var k=0, l=category[i].length; k < l; k++) {
        }
    }
}
*/
function getItems(){
  
   var getListdiv = document.getElementById("new");
   
   for (var i = 0, len = localStorage.length; i < len; i++) {
        var key = localStorage.key(i);
        var value = localStorage.getItem(key);
        value = value.split(";");
        var practiceC   =value[0];
        var prname      =value[1];
        var timesig     =value[2];
        var BPMs        =value[3];
        var favirote    =value[4];
        var date        =value[5];
        var Notes       =value[6];
        var newDiv = document.createElement("div");
        for (var k = 0, allLength = value.length; k < allLength; k++) {
            var newPara = document.createElement("p");
            var itemTxt = document.createTextNode(value[k]);
            newPara.appendChild(itemTxt);
            newDiv.appendChild(newPara);
            getListdiv.appendChild(newDiv);
        }
        //attemp to adding images per category
        var image ="";
            if (practiceC =="") {image ="";}
            if (practiceC =="Hands" || "Feet" || "Drumset") {image ="Rudiments.png";}
            if (practiceC =="Jazz" || "Rock" || "Funk") {image ="beats.png";}
            if (practiceC =="Feet/Hands" || "Hands/Feet") {image = "Ostinatos.png";}
         
         //add images   
        var newImg = document.createElement("img");
        var setSrc = newImg.setAttribute("src=","img/" + image + ".png");
        getList.appendChild(newImg);
        
        
   //add delete single item link
   var deleteLink = document.createElement("a");
   var setHref    = deleteLink.setAttribute("href", "#");
   var setOnclick = deleteLink.setAttribute("onclick", "deleteItem(" + key + ");");
   var deleteText = document.createTextNode("delete item");
   deleteLink.appendChild(deleteText);
   newDiv.appendChild(deleteLink);
   
   //add edit single item
   var editLink         = document.createElement("a");
   var setEditHref      = editLink.setAttribute("href", "#");
   var setEditOnclick   = editLink.setAttribute("onclick", "editItem(" + key + ");");
   var editText         = document.createTextNode("edit item");
   editLink.appendChild(editText);
   newDiv.appendChild(editLink);
      
    if(localStorage.getItem("apppracticeC")) {
    /*  var practiceC   = localStorage.getItem("apppracticeC");
        var prname      = localStorage.getItem("appprname");
        var timesig     = localStorage.getItem("apptimesig");
        var BPMs        = localStorage.getItem("appBPMs");
        var favorite    = localStorage.getItem("appfavorite");
        var date        = localStorage.getItem("appdate");
        var Notes       = localStorage.getItem("appNotes");
        
        var DrumsetPraList = [
            practiceC,
            prname,
            timesig,
            BPMs,
            favorite,
            date,
            Notes
        ];
    */
    
        document.getElementById("form").style.display = "none";
        document.getElementById("clear").style.display = "block";
        var getList = document.getElementById("new");
        for (var i=0, j=DrumsetPraList.length; i < j; i++) {
            var newData = document.createElement("p");
            var itemTxt = document.createTextNode(DrumsetPraList[i]);
            newData.appendChild(itemTxt);
            getList.appendChild(newData);
        }
    } else {
            var  prname    = "enter practoce name";
            var  timesig   = "enter a time signature";
            var  BPMs      = "enter a BPM's"
            
            document.getElementById("prname").value = prname;
            document.getElementById("timesig").value = timesig;
            document.getElementById("BPMs").value = BPMs;
        }
}

//save items function. get date and time from comp...
function saveItems(id) {
    var d = new Date();
    var key = (d.getTime());
    var practiceC = document.getElementById("practiceC").value;
    var prname    = document.getElementById("prname").value;
    var timesig   = document.getElementById("timesig").value;
    var BPMs      = document.getElementById("BPMs").value;
    var favirote  = document.getElementById("favirote").value;
    var date      = document.getElementById("date").value;
    var Notes     = document.getElementById("Notes"),value;
    
    var allItems  = [
            practiceC,
            prname,
            timesig,
            BPMs,
            favorite,
            date,
            Notes
        ];
    localStorage.setItem(key, allItems);
}


function storeData(id) {
    validateForm();
    var practiceC    = document.getElementById("practiceC").value;
    var prname       = document.getElementById("prname").value;
    var timesig      = document.getElementById("timesig").value;
    var BPMs         = document.getElementById("BPMs").value;
    var favorite     = document.getElementById("favorite").value;
    var date         = document.getElementById("date").value;
    var Notes        = document.getElementById("Notes").value;
    
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
    
    value.value.split(";");
    var practiceC   = value[0];
    var prname      = value[1];
    var timesig     = value[2];
    var BPMs        = value[3];
    var favorite    = value[4];
    var date        = value[5];
    var Notes       = value[6];
    
    //populates form fields with current localStorage values
    document.getElementById("practiceC").value = practiceC;
    document.getElementById("prname").value = prname;
    document.getElementById("timesig").value = timesig;
    document.getElementById("BPMs").value = BPMs;
    if (favirote =="on") {
        document.getElementById("favirote").setAttribute("checked", "checked");
    }
    document.getElementById("date").value = date;
    document.getElementById("Notes").value = Notes;
    
    //reveal editItems button, hide submit button
    var editItem = document.getElementById('editItem');
    editItem.style.display = "block";
    var submit = document.getElementById("submit");
    submit.style.display = "none";
    
    //capture editItem button's click
    document.getElementById("editItem").onclick = function () {
        
        var practiceC       = document.getElementById("practiceC").value;
        var prname          = document.getElementById("prname").value;
        var timesig         = document.getElementById("timesig").value;
        var BPMs            = document.getElementById("BPMs").value;
        var favorite        = document.getElementById("favorite").value;
        var date            = document.getElementById("date").value;
        var Notes           = document.getElementById("Notes").value;
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
    document.getElementById("clear").style.display = "none";

    return false;
}