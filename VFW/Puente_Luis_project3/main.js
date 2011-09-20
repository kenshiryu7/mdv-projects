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
   
   /*var getListdiv = document.getElementById("list");
   
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
            var newParas = document.createElement("p");
            var itemTxt = document.createTextNode(value[k]);
            newParas.appendChild(itemTxt);
            newDiv.appendChild(newParas);
            getListdiv.appendChild(newDiv);
        }
        
        var newImg = document.createElement("img");
        var setSrc = newImg.setAttribute("src=","img/" + practiceC + ".png");
        getList.appendChild(newImg);*/
/*   
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
 */       
    if(localStorage.getItem("apppracticeC")) {
        var practiceC   = localStorage.getItem("apppracticeC");
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
        
        document.getElementById("form").style.display = "none";
        document.getElementById("clear").style.display = "block";
        var getList = document.getElementById("new");
        for (var i=0, j=DrumsetPraList.length; i < j; i++) {
            var newData = document.createElement("p");
            var itemTxt = document.createTextNode(DrumsetPraList[i]);
            newData.appendChild(itemTxt);
            getList.appendChild(newData);
        }
        //unable to finish the work up to allow images per catName...need help...
        /*var newImg = document.createElement("img");
        var setSrc = newImg.setAttribute("src=","img/" + practiceC + ".png");
        getList.appendChild(newImg);*/
        
        //alert(DrumsetPraList);
       anchorTags[0].style.color = "blue";
     }
}

function storeData(id) {
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

function clearLocal() {
    localStorage.clear();
    document.getElementById("clear").style.display = "none";

    return false;
}