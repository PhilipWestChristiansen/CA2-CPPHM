$(document).ready(function () {

    $("#getPersonById").click(function () {
        
        console.log("button clicked");

        var input = document.getElementById("id").value;
        
        
        var xmlhttp = new XMLHttpRequest();
        var url = "http://localhost:8080/CA2-v2/api/person/complete/" + input;
        console.log(url);
        xmlhttp.onreadystatechange = function ()
        {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
            {
                person = JSON.parse(xmlhttp.responseText);
                console.log("run method");
                createTable();
            }
        };
        xmlhttp.open("GET", url, true);
        xmlhttp.send();
    });
});

function createTable()
{
    
        
        
        var table = document.getElementById("table");
        var row = table.insertRow(0);
        
        
        row.insertCell(0).innerHTML = person.id;
        row.insertCell(1).innerHTML = person.firstname;
        row.insertCell(2).innerHTML = person.lastname;
        row.insertCell(3).innerHTML = person.email;
        row.insertCell(4).innerHTML = person.street;
        row.insertCell(5).innerHTML = person.zipcode;
        row.insertCell(6).innerHTML = person.city;
        
        for (var i = 0; i < person.phones.length ; i++) {
        row.insertCell(7).innerHTML = person.phones[i].number;
        row.insertCell(7).innerHTML = person.phones[i].description;
    }

    
}