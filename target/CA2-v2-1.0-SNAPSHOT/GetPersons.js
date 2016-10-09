$(document).ready(function () {

    $("#getPersons").click(function () {

        console.log("button clicked");

        var xmlhttp = new XMLHttpRequest();
        var url = "http://localhost:8080/CA2-v2/api/person/complete";
        console.log(url);
        xmlhttp.onreadystatechange = function ()
        {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
            {
                console.log("before json parse");
                persons = JSON.parse(xmlhttp.responseText);
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

    for (var i = 0; i < persons.length; i++) {
        
        var row = table.insertRow(0);

        row.insertCell(0).innerHTML = persons[i].id;
        row.insertCell(1).innerHTML = persons[i].firstname;
        row.insertCell(2).innerHTML = persons[i].lastname;
        row.insertCell(3).innerHTML = persons[i].email;
        row.insertCell(4).innerHTML = persons[i].street;
        row.insertCell(5).innerHTML = persons[i].zipcode;
        row.insertCell(6).innerHTML = persons[i].city;

        for (var j = 0; j < persons[i].phones.length; j++) {
            row.insertCell(7).innerHTML = persons[i].phones[j].number;
            row.insertCell(7).innerHTML = persons[i].phones[j].description;
        }
    }


}