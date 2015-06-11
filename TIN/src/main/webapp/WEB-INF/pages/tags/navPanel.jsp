<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="navMenu" class="fixed-nav-bar">
    <a href="/tin/baskets" class="btn btn-info" role="button">Wróć</a>
    <button type="button" id="logOut" class="btn btn-danger">
    <a style="color:#ffffff; background-color:transparent; text-decoration:none" href="logOut">Wyloguj się</a></button><br>
    <button type="button" id="addNewRecord" class="btn btn-success" onclick="addNewRecord();">Dodaj pracę</button>
    <button type="button" id="saveAll" class="btn btn-success" onclick="saveAllRecords();">Zapisz</button><br>
    <button type="button" id="XML" class="btn btn-success" onclick="generateXML();">Pobierz Inż</button>
    <button type="button" id="XML2" class="btn btn-success" onclick="generateXMLmag();">Pobierz Mgr</button>
    <nav >
        <!-- Fixed navigation bar content -->
        <div id="navbar" >
            <div class="list-group">
            </div>
        </div>

    </nav>

</div>