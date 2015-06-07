/**
 * Created by PK on 4/19/2015.
 */

$( document ).ready(function() {
    $("button#add").click(function(){
        var x = prompt("Prosze wpisac nazwe nowego koszyka: ");
        if(x == null) {
            return;
        } else if(x == ''){
            alert("Wpisana pusta wartosc, koszyk nie dodany");
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
    if(!confirm("Czy jestes pewen, ze chcesz usunac ten koszyk?"))
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
    var x = prompt("Prosze wpisac nowa nazwe koszyka: ");
    if(x == null) {
        return;
    } else if(x == ''){
        alert("Wpisana pusta wartosc, koszyk nie zmieniony");
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
    var oldPassword = prompt("Prosze podac aktualnie haslo: ");
    if(oldPassword == null) {
        return;
    }
    var newPassword = prompt("Prosze podac nowe haslo: ");
    if(newPassword == null) {
        return;
    }
    var newPasswordConfirm = prompt("Prosze podac powtorzyc nowe haslo: ");
    if(newPasswordConfirm == null) {
        return;
    }
    if(newPassword != newPasswordConfirm){
        alert("Podane haslo sie rozni od potwierdzenia, zmiana nie nastapila");
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
                alert("Zmiana hasla zostala zapisana na serwerze");
            } else {
                alert("Serwer odmowil w zmianie hasla, sproboj ponownie");
            }
        },
        error: function(request, status, error){
            alert("Error: haslo nie zmienione\n" + request.responseText);
        }
    });
}
