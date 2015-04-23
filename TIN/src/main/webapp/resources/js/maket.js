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