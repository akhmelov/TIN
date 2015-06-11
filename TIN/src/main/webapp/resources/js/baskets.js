/**
 * Created by PK on 4/19/2015.
 */

$( document ).ready(function() {
    $("button#add").click(function(){
        var x = prompt("Proszę wpisać nazwę nowego zbioru: ");
        if(x == null) {
            return;
        } else if(x == ''){
            alert("Nie podano nazwy, zbiór nie został dodany.");
            return;
        }
        var form = document.createElement("form");
        form.setAttribute("method", "POST");
        form.setAttribute("action", "baskets");

        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", "nameBasket");
        hiddenField.setAttribute("value", x);

        form.appendChild(hiddenField);

        document.body.appendChild(form);
        form.submit();
    });
});

function deleteBasket(id){
    if(!confirm("Czy na pewno chcesz usunąć ten zbiór?"))
        return
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

function editBasket(id){
    var x = prompt("Proszę wpisac nową nazwę abioru: ");
    if(x == null) {
        return;
    } else if(x == ''){
        alert("Nie podano nazwy, nazwa zbioru nie została zmieniona.");
        return;
    }
    var form = document.createElement("form");
    form.setAttribute("method", "POST");
    form.setAttribute("action", "editBasket");

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "idBasket");
    hiddenField.setAttribute("value", id);
    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "nameBasket");
    hiddenField.setAttribute("value", x);
    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
}

function changePassword(){
    var oldPassword = prompt("Proszę podać obecne hasło: ");
    if(oldPassword == null) {
        return;
    }
    var newPassword = prompt("Proszę podać nowe hasło: ");
    if(newPassword == null) {
        return;
    }
    var newPasswordConfirm = prompt("Proszę powtórzyć nowe hasło: ");
    if(newPasswordConfirm == null) {
        return;
    }
    if(newPassword != newPasswordConfirm){
        alert("Podane hasło rożni się od potwierdzenia, zmiana nie nastąpiła.");
        return;
    }
    var form = document.createElement("form");
    form.setAttribute("method", "POST");
    form.setAttribute("action", "changePassword");
    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "oldPassword");
    hiddenField.setAttribute("value", oldPassword);
    form.appendChild(hiddenField);
    hiddenField = document.createElement("input");
    hiddenField.setAttribute("name", "newPassword");
    hiddenField.setAttribute("value", newPassword);
    form.appendChild(hiddenField);
    var tmp = $(form).serialize();
    $.ajax({
        type: "POST",
        url: "changePassword",
        data: $(form).serialize(), // serializes the form's elements.
        success: function(data)
        {
            if(data + "" == "true")
            {
                alert("Zmiana hasła zostala zapisana na serwerze.");
            } else {
                alert("Serwer odmówił zmiany hasła, spróbuj ponownie.");
            }
        },
        error: function(request, status, error){
            alert("Error: hasło nie zostało zmienione.\n" + request.responseText);
        }
    });
}
