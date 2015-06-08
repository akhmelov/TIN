/**
 * Created by PK on 4/19/2015.
 */

$( document ).ready(function() {
    $("button#add").click(function(){
        $( "#dialog" ).dialog();
    });

    $("button#userForm").click(function(){

        var userForm = $("form#userForm");
        var mail = userForm.find("#name").val();
        var name = userForm.find("#name").val();
        var surname = userForm.find("#name").val();
        var password = userForm.find("#name").val();

        //if(mail.empty() || name.empty() || surname.empty() || password.empty())
        //{
        //    alert("Masz puste pole, usupelniej to");
        //    return;
        //}

        var form = document.createElement("form");
        form.setAttribute("method", "POST");
        form.setAttribute("action", "admin");
        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", "mail");
        hiddenField.setAttribute("value", mail);
        form.appendChild(hiddenField);
        hiddenField = document.createElement("input");
        hiddenField.setAttribute("name", "name");
        hiddenField.setAttribute("value", name);
        form.appendChild(hiddenField);
        hiddenField = document.createElement("input");
        hiddenField.setAttribute("name", "surname");
        hiddenField.setAttribute("value", surname);
        form.appendChild(hiddenField);
        hiddenField = document.createElement("input");
        hiddenField.setAttribute("name", "password");
        hiddenField.setAttribute("value", password);
        form.appendChild(hiddenField);

        form.appendChild(hiddenField);

        document.body.appendChild(form);
        form.submit();
    });
});

function deleteBasket(id){
    if(!confirm("Czy jestes pewen, ze chcesz usunac tego u�ytkownika?"))
        return;
    var form = document.createElement("form");
    form.setAttribute("method", "POST");
    form.setAttribute("action", "deleteBasket");

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "idBasket");
    hiddenField.setAttribute("value", id);

    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
}

function editUser(id){
    $( "#dialogEdit" ).dialog();
    var userForm = $("form#userEditForm");
    var mail = userForm.find("#name").val();
    var name = userForm.find("#name").val();
    var surname = userForm.find("#name").val();
    var password = userForm.find("#name").val();
}

function editUserSend(id){
    var userForm = $("form#userEditForm");
    var mail = userForm.find("#name").val();
    var name = userForm.find("#name").val();
    var surname = userForm.find("#name").val();
    var password = userForm.find("#name").val();

    //if(mail.empty() || name.empty() || surname.empty() || password.empty())
    //{
    //    alert("Masz puste pole, usupelniej to");
    //    return;
    //}

    var form = document.createElement("form");
    form.setAttribute("method", "POST");
    form.setAttribute("action", "admin");
    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "mail");
    hiddenField.setAttribute("value", mail);
    form.appendChild(hiddenField);
    hiddenField = document.createElement("input");
    hiddenField.setAttribute("name", "name");
    hiddenField.setAttribute("value", name);
    form.appendChild(hiddenField);
    hiddenField = document.createElement("input");
    hiddenField.setAttribute("name", "surname");
    hiddenField.setAttribute("value", surname);
    form.appendChild(hiddenField);
    hiddenField = document.createElement("input");
    hiddenField.setAttribute("name", "password");
    hiddenField.setAttribute("value", password);
    form.appendChild(hiddenField);
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "idUser");
    hiddenField.setAttribute("value", id);
    form.appendChild(hiddenField);

    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
}
