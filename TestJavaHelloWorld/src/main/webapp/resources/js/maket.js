var records = [];

$( document ).ready(function() {
    $.ajax({
        url: "getRecordsJson",
        type: "POST",
        //contentType: 'application/json',
        success: function(recordsf){
            for(var el in recordsf) {
                var rec = creatRecord();
                var tmp = recordsf[el];
                rec.setId(tmp.id);
                rec.setNameStudent(tmp.nameStudent);
                rec.setSurnameStudent(tmp.surnameStudent);
                rec.setter(idFields[emailStudent], tmp.mailStudent);
                rec.setter(idFields[titlePL], tmp.titlePL);
                rec.setter(idFields[titleEN], tmp.titleEN);
                rec.setter(idFields[namePromotor], tmp.namePromoter);
                rec.setter(idFields[surnamePromotor], tmp.surnamePromoter);
                rec.setter(idFields[abstractPL], tmp.abstractPL);
                rec.setter(idFields[abstractEN], tmp.abstractEN);
                rec.setter(idFields[keyWordsPL], tmp.keyWordsPL);
                rec.setter(idFields[keyWordsEN], tmp.keyWordsEN);
                records.push(rec);
            }
            refreshAll();
        },
        error: function(request, status, error){
            $("body").html(request.responseText);
        }
    });
});

var idFields = new Array();
    var nameStudent = "nameStudent";
    var surnameStudent = "surnameStudent";
    var emailStudent = "mailStudent";
    var titlePL = "titlePL";
    var titleEN = "titleEN";
    var namePromotor = "namePromoter";
    var surnamePromotor = "surnamePromoter";
    var abstractPL = "abstractPL";
    var abstractEN = "abstractEN";
    var keyWordsPL = "keyWordsPL";
    var keyWordsEN = "keyWordsEN";
    idFields[nameStudent] = "nameStudent";
    idFields[surnameStudent] = "surnameStudent";
    idFields[emailStudent] = "mailStudent";
    idFields[titlePL] = "titleEssayPL";
    idFields[titleEN] = "titleEssayEN";
    idFields[namePromotor] = "namePromotor";
    idFields[surnamePromotor] = "surnamePromotor";
    idFields[abstractPL] = "abstractPL";
    idFields[abstractEN] = "abstractEN";
    idFields[keyWordsPL] = "keyWordsPL";
    idFields[keyWordsEN] = "keyWordsEN";

function creatRecord()
{
    var record = {
        changed: true //is saved on server?
    };

    function init(){
        for(var el in idFields){
            record[el] = "";
        }
    }
    init();
    record.hasError = function(){
        for(var el in idFields){
            if(el === abstractEN || el === abstractPL)
                continue;
            if(record[el].length < 1)
                return true;
        }
        return false;
    }
    record.saveOnServer = function(){
        return function() {
            var sendData = {
                "id": parseInt(record.getId()),
                "isMA": false,
                nameStudent : record[nameStudent],
                surnameStudent : record[surnameStudent],
                mailStudent : record[emailStudent],
                titlePL : record[titlePL],
                titleEN : record[titleEN],
                namePromoter : record[namePromotor],
                surnamePromoter : record[surnamePromotor],
                abstractPL : record[abstractPL],
                abstractEN : record[abstractEN],
                keyWordsPL : record[keyWordsPL],
                keyWordsEN : record[keyWordsEN]
            }
            $.ajax({
                url: "saveRecord",
                contentType : 'application/json; charset=utf-8',
                dataType : 'json',
                type: "POST",
                data: JSON.stringify(sendData), // Note it is important
                //contentType: 'application/json',
                success: function(answer){
                    alert("saved");
                },
                error: function(request, status, error){
                    $("body").html(request.responseText);
                }
            });
        }
    }
    record.deleteOnServer = function(){
        return function() {
            var sendData = {
                idRecord: parseInt(record.getId())
            }
            $.ajax({
                    url: "deleteRecord",
                    contentType : 'application/json; charset=utf-8',
                    dataType : 'json',
                    type: "POST",
                    data: JSON.stringify(sendData), // Note it is important
                    //contentType: 'application/json',
                    success: function(answer){
                        alert("deleted");
                },
                error: function(request, status, error){
                $("body").html(request.responseText);
                }
            });
        }
    }
    function isChanged(objectId){
        var obj = record.record.find("#" + objectId);
        var sendData = {
            "id": parseInt(record.getId()),
            "isMA": false,
            nameStudent : record[nameStudent],
            surnameStudent : record[surnameStudent],
            mailStudent : record[emailStudent],
            titlePL : record[titlePL],
            titleEN : record[titleEN],
            namePromoter : record[namePromotor],
            surnamePromoter : record[surnamePromotor],
            abstractPL : record[abstractPL],
            abstractEN : record[abstractEN],
            keyWordsPL : record[keyWordsPL],
            keyWordsEN : record[keyWordsEN]
        }
        $.ajax({
            url: "hasChangeRecord",
            contentType : 'application/json; charset=utf-8',
            dataType : 'json',
            type: "POST",
            data: JSON.stringify(sendData), // Note it is important
            //contentType: 'application/json',
            success: function(answer){
                if(answer){
                    //if(obj.hasClass("has-error")) {
                    //    obj.removeClass("has-change");
                    //}
                    //else
                    //    obj.addClass("has-change");
                    if(record.linkNavPanel.hasClass("has-error"))
                        record.linkNavPanel.removeClass("has-change");
                    else
                        record.linkNavPanel.addClass("has-change");
                    record.changed = true;
                } else {
                    record.linkNavPanel.removeClass("has-change");
                    obj.removeClass("has-change");
                }
            },
            error: function(request, status, error){
                $("body").html(request.responseText);
            }
        });
    }
    record.record = $("div#contentPanel.panel.panel-default").clone(true);
    record.linkNavPanel = $("a#linkToStudent").clone(true);

    record.setId = function(id){
        record.id = id;
        record.record.attr("id", "record-" + id);
        record.linkNavPanel.attr("id", "arecord-" + id);
        record.linkNavPanel.attr("href", "#record-" + id);
    }
    record.getId = function(){
        return record.record.attr("id").split("-", 2)[1];
    }

    record.setNameStudent = function(name){
        record.record.find("#" + idFields[nameStudent]).val(name);
        record.linkNavPanel.find("span#" + idFields[nameStudent]).html(name);
        record[nameStudent] = name;
    }

    record.setSurnameStudent = function(surname){
        record.record.find("#" + idFields[surnameStudent]).val(surname);
        record.linkNavPanel.find("span#" + idFields[surnameStudent]).html(surname);
        record[surnameStudent] = surname;
    }

    record.setter = function(objectId, val){
        var tmp = setterInput(objectId);
        tmp(val);
    }

    function setterInput(objectId){
        return function(val) {
            var obj = record.record.find("#" + objectId);
            obj.val(val);
            for(var el in idFields){
                if(objectId == idFields[el]) {
                    record[el] = obj.val();
                    break;
                }
            }
        }
    }

    function getterInput(objectId){
        return function(){
            var obj = record.record.find("#" + objectId);
            return obj.val();
        }
    }

    //setting lintens
    record.linkNavPanel.find("#save").click(record.saveOnServer());
    record.linkNavPanel.find("#delete").click(record.deleteOnServer());
    record.record.find("#save").click(record.saveOnServer());
    record.record.find("#delete").click(record.deleteOnServer());
    record.record.find("#" + idFields[nameStudent]).focusout(isEmpty(idFields[nameStudent], record.setNameStudent));
    record.record.find("#" + idFields[surnameStudent]).focusout(isEmpty(idFields[surnameStudent], record.setSurnameStudent));
    record.record.find("#" + idFields[emailStudent]).focusout(isEmpty(idFields[emailStudent]));
    record.record.find("#" + idFields[titlePL]).focusout(isEmpty(idFields[titlePL]));
    record.record.find("#" + idFields[titleEN]).focusout(isEmpty(idFields[titleEN]));
    record.record.find("#" + idFields[titlePL]).focusout(isEmpty(idFields[abstractPL]));
    record.record.find("#" + idFields[titleEN]).focusout(isEmpty(idFields[abstractEN]));
    record.record.find("#" + idFields[namePromotor]).focusout(isEmpty(idFields[namePromotor]));
    record.record.find("#" + idFields[surnamePromotor]).focusout(isEmpty(idFields[surnamePromotor]));
    record.record.find("#" + idFields[keyWordsPL]).focusout(isEmpty(idFields[keyWordsPL]));
    record.record.find("#" + idFields[keyWordsEN]).focusout(isEmpty(idFields[keyWordsEN]));

    function isEmpty(objectId, setter, getter){
        var object = record.record.find("#" + objectId);
        setter = typeof setter !== 'undefined' ? setter : setterInput(objectId);
        getter = typeof getter !== 'undefined' ? getter : getterInput(objectId);
        return function() {
            var val = object.val();
            setter(getter());
            if (val.length < 1) {
                object.addClass("has-error");
                //if(object.hasClass("has-change"))
                //    object.removeClass("has-change");
                record.linkNavPanel.addClass("has-error");
                if(record.linkNavPanel.hasClass("has-change"))
                    record.linkNavPanel.removeClass("has-change");
            } else {
                object.removeClass("has-error");
                if(!record.hasError())
                    record.linkNavPanel.removeClass("has-error");
            }
            isChanged(objectId);
        }
    }

    return record;
}

function addNewRecord()
{
    var obj = creatRecord();
    obj.setId(records.length);
    records.push(obj);
    var navlink = $("div#navMenu div#navbar div.list-group");
    var divForms = $("div#studentsForm");
    navlink.append(obj.linkNavPanel);
    divForms.append(obj.record);
}

function refreshAll()
{
    var divForms = $("div#studentsForm");
    var navlink = $("div#navMenu div#navbar div.list-group");
    for(var el in records){
        var obj = records[el];
        navlink.append(obj.linkNavPanel);
        divForms.append(obj.record);
    }
}