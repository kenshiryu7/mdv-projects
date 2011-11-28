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
            if ((practiceC =="Hands") || (practiceC =="Feet") || (practiceC =="Drumset")) {image ="Rudiments.png";}
            if ((practiceC =="Feet/Hands") || (practiceC =="Hands/Feet")) {image = "Ostinatos.png";}
            if ((practiceC =="Jazz") || (practiceC =="Rock") || (practiceC =="Funk")) {image ="beats.png";}
        
    
         //add images   
        var newImg = document.createElement("img");
        var setSrc = newImg.setAttribute("src","img/" + image);
        getListdiv.appendChild(newImg);
       
        
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
   }
   
    if(localStorage.length >=1) {
        var clearLink = $('#clear').show();
        
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
    
        /*document.getElementById("form").style.display = "none";
        document.getElementById("clear").style.display = "block";
        var getList = document.getElementById("new");
        for (var i=0, j=DrumsetPraList.length; i < j; i++) {
            var newData = document.createElement("p");
            var itemTxt = document.createTextNode(DrumsetPraList[i]);
            newData.appendChild(itemTxt);
            getList.appendChild(newData);
        }*/
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
        $('#favorite').setAttribute("checked", "checked");
    }
    $('#date').val(date);
    $('#Notes').val(Notes);
    
    //reveal editItems button, hide submit button
    var editItem = $('#editItem').show();
    
    var submit = $('#sdata').show();
    
    //capture editItem button's click
    document.getElementById("editItem").onclick = function () {
        
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

//attempt at dummy data

(function(storage) {
    var appName ="Drumset Practice List";

var drumKey = appName + ".installed";

if(storage.getItem(drumKey) !== null) {return;}

var initalData = [
    {
    "practiceC":    "Hands",
    "prname" :      "left hand exc",
    "timesig":      "4/4",
    "BPMs":         "60",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "I hate working the left hand!"
    },
    {
    "practiceC":    "Feet",
    "prname" :      "right foot exc",
    "timesig":      "4/4",
    "BPMs":         "100",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "great exc for speed"
    },
    {
    "practiceC":    "Drumset",
    "prname" :      "around the set",
    "timesig":      "4/4",
    "BPMs":         "110",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "great for fills!"
    },
    {
    "practiceC":    "Hands",
    "prname" :      "speed exc",
    "timesig":      "4/4",
    "BPMs":         "220",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "good build up"
    },
    {
    "practiceC":    "Feet",
    "prname" :      "speed exc",
    "timesig":      "4/4",
    "BPMs":         "200",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "hard but productive"
    },
    {
    "practiceC":    "Drumset",
    "prname" :      "toms only",
    "timesig":      "4/4",
    "BPMs":         "120",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "nice exc around set"
    },
    {
    "practiceC":    "Jazz",
    "prname" :      "independence",
    "timesig":      "3/4",
    "BPMs":         "140",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "hard time, good practice"
    },
    {
    "practiceC":    "Rock",
    "prname" :      "basic fat beat",
    "timesig":      "6/8",
    "BPMs":         "105",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "good stuff!!"
    },
    {
    "practiceC":    "Funk",
    "prname" :      "the nasty",
    "timesig":      "6/8",
    "BPMs":         "90",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "Can change tempo for diff feel"
    },
    {
    "practiceC":    "Jazz",
    "prname" :      "Elvin Jones Triplets",
    "timesig":      "4/4",
    "BPMs":         "130",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "need more practice"
    },
    {
    "practiceC":    "Rock",
    "prname" :      "John Bohnom Triplets",
    "timesig":      "4/4",
    "BPMs":         "90",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "awesome"
    },
    {
    "practiceC":    "Funk",
    "prname" :      "Fast Funk",
    "timesig":      "6/8",
    "BPMs":         "140",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "hard but awesome!!"
    },
    {
    "practiceC":    "Feet/Hands",
    "prname" :      "feet patterns",
    "timesig":      "4/4",
    "BPMs":         "90",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "hate this!!"
    },
    {
    "practiceC":    "Hands/Feet",
    "prname" :      "soloing over feet",
    "timesig":      "4/4",
    "BPMs":         "100",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "nice  but why?"
    },
    {
    "practiceC":    "Feet/Hands",
    "prname" :      "independence exc for feet",
    "timesig":      "4/4",
    "BPMs":         "90",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "good stuff!"
    },
    {
    "practiceC":    "Hands/Feet",
    "prname" :      "killer ",
    "timesig":      "4/4",
    "BPMs":         "80",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "tough but necessary"
    },
    {
    "practiceC":    "Hands",
    "prname" :      "warm ups",
    "timesig":      "4/4",
    "BPMs":         "80",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "great exercise!"
    },
    {
    "practiceC":    "Feet",
    "prname" :      "double pedal exc",
    "timesig":      "4/4",
    "BPMs":         "90",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "finally! need better pedal"
    },
    {
    "practiceC":    "Drumset",
    "prname" :      "simple yet awesome",
    "timesig":      "4/4",
    "BPMs":         "120",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "love this"
    },
    {
    "practiceC":    "Jazz",
    "prname" :      "relax, speed",
    "timesig":      "4/4",
    "BPMs":         "185",
    "favorite":     "",
    "date":         "9-27-2011",
    "Notes":        "Slow build up helps"
    },
];

var populate = function(data) {
    for (var i in data) {
        var item = data[i];
        var key  = item.id;
        
        var value = [item.id, item.name, item.cat].join(";");
        //easy way
        //var value = JSON.stringify(item);
        storage.setItem(key, value);
     }
    };

    console.log("Pupulating initial data.");
    populate(initialData);

    storage.setItem(drumKey,"");
    console.log(storage);
})(window.localStorage);
 
 
    
});