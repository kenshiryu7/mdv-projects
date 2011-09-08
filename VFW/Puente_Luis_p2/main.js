//Luis Puente
//local storage

var clearLink = document.getElementById("clear");
var anchorTags = clearLink.getElementsByTagName("a");

function mouseHover() {
    for ( var i=0, j=anchorTags.length; i < j; i++) {
        anchorTags[i].style.color = "#009900";
    }
}

function mouseOut() {
    for ( var i=0, j=anchorTags.length; i < j; i++) {
        anchorTags[i].style.color = "blue";
    }
}

function getItems(){
    if(localStorage.getItem("apppracticeC")) {
        var practiceC   = localStorage.getItem("apppracticeC");
        var prname      = localStorage.getItem("appprname");
        var timesig     = localStorage.getItem("apptimesig");
        var BPMs        = localStorage.getItem("appBPMs");
        var favirote    = localStorage.getItem("appfavirote");
        var date        = localStorage.getItem("appdate");
        var Notes       = localStorage.getItem("appNotes");
        
        var DrumsetPraList = [
            practiceC,
            prname,
            timesig,
            BPMs,
            favirote,
            date,
            Notes
        ];
        
        alert(DrumsetPraList);
     }
}

function storeData(id) {
    var practiceC    = document.getElementById("practiceC").value;
    var prname       = document.getElementById("prname").value;
    var timesig      = document.getElementById("timesig").value;
    var BPMs         = document.getElementById("BPMs").value;
    var favirote     = document.getElementById("favirote").value;
    var date         = document.getElementById("date").value;
    var Notes        = document.getElementById("Notes").value;
    
    localStorage.setItem("apppracticeC", practiceC);
    localStorage.setItem("appprname", prname);
    localStorage.setItem("apptimesig", timesig);
    localStorage.setItem("appBPMs", BPMs);
    localStorage.setItem("appfavirote", favirote);
    localStorage.setItem("appdate", date);
    localStorage.setItem("appNotes", Notes);
}

function clearLocal() {
    localStorage.clear();
    return false;
}