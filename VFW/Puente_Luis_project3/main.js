//Luis Puente
//local storage

var clearLink = document.getElementById("clear");
var anchorTags = clearLink.getElementsByTagName("a");

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

function getItems(){
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
        /*var beatsImg = "img/beats.png";
        var ostinatos = "img/Ostinatos.png";
        var rudiments = "img/Rudiments.png";
        */
       // alert(DrumsetPraList);
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