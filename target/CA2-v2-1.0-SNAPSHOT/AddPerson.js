$(document).ready(function () {

    $("#addPerson").click(function () {
        console.log("run person add method");
        PersonAdd();
    });

    function PersonAdd()
    {
        var person = '{ firstName: ' + $("#PersonFirstName").val() + ', lastName: ' + $("#PersonLastName").val() + ' }';

        console.log(person);

        $.ajax({
            url: "api/person/complete",
            type: "POST",
            data: person,
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success: function () {}
        });
    }
});