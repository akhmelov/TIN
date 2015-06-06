<a href="#" id="linkToStudent" class="list-group-item list-group-item-success">
    <span id="nameStudent">No name</span>
    <span id="surnameStudent">No surname</span>
    <span id="save" class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
    <span id="delete" class="glyphicon glyphicon-trash" aria-hidden="true"></span>
</a>
<div id="contentPanel" class="panel panel-default" style="width: 80%; border-color: black; border-width: 2px;">
    <div class="panel-heading">
        <h3 class="panel-title">Profil studenta</h3>
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-lg-6">
                <div class="input-group">
                    <form id="type">
                        <span class="input-group-addon">
                            Inzynierska<input type="radio" name="type" id="engineer" checked aria-label="...">
                        </span>
                        <span class="input-group-addon">
                            Magisterska<input type="radio" name="type" id="magister" aria-label="...">
                        </span>
                    </form>
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </div><!-- /.row -->
        <hr/>
        Student
        <div class="row">
            <div class="col-lg-3">
                <div class="input-group input-group-sm">
                    <span class="input-group-addon">
                        Imie
                    </span>
                    <input type="text" id="nameStudent" class="form-control" aria-label="..." placeholder="Imie">
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
            <div class="col-lg-3">
                <div class="input-group input-group-sm">
                    <span class="input-group-addon">
                        Nazwisko
                    </span>
                    <input id="surnameStudent" type="text" class="form-control" aria-label="..." placeholder="Nazwisko">
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
            <div class="col-lg-3">
                <div class="input-group input-group-sm">
                    <span class="input-group-addon">
                      @
                    </span>
                    <input type="text" id="mailStudent" class="form-control" aria-label="..." placeholder="email">
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </div> <!-- /row -->
        <br/>
        <div class="row">
            <div class="col-lg-8">
                <div class="input-group input-group-sm">
                              <span class="input-group-addon">
                                Tytul pracy PL
                              </span>
                    <input type="text" id="titleEssayPL" class="form-control" aria-label="..." placeholder="Tytul">
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </div><!-- /row -->
        <br/>
        <div class="row">
            <div class="col-lg-8">
                <div class="input-group input-group-sm">
                              <span class="input-group-addon">
                                Tytul pracy EN
                              </span>
                    <input type="text" id="titleEssayEN" class="form-control" aria-label="..." placeholder="Tytul">
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </div> <!-- /row -->
        <br/>
        <span>Promotor<span>
        <div class="row">
            <div class="col-lg-3">
                <div class="input-group input-group-sm">
                  <span class="input-group-addon">
                  </span>
                    <input type="text" id="namePromotor" class="form-control" aria-label="..." placeholder="Imie">
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
            <div class="col-lg-3">
                <div class="input-group input-group-sm">
                  <span class="input-group-addon">
                  </span>
                    <input type="text" id="surnamePromotor" class="form-control" aria-label="..." placeholder="Nazwisko">
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </div>
        <br/>
        <hr/>
        <div class="row">
            <div class="col-lg-6">
                <form role="form">
                    <div class="form-group">
                        <label for="comment">Abstrakt PL:</label>
                        <textarea class="form-control" id="abstractPL" rows="5" id="comment"></textarea>
                    </div>
                </form>
            </div>
        </div> <!-- /row -->
        <div class="row">
            <div class="col-lg-6">
                <form role="form">
                    <div class="form-group">
                        <label for="comment">Abstrakt EN:</label>
                        <textarea class="form-control" id="abstractEN" rows="5" id="comment"></textarea>
                    </div>
                </form>
            </div>
        </div> <!-- /row -->
        <div class="row">
            <div class="col-lg-8">
                <div class="input-group input-group-sm">
                      <span class="input-group-addon">
                        Slowa kluczowe PL
                      </span>
                      <input type="text" id="keyWordsPL" class="form-control" aria-label="..." placeholder="">
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </div><!-- /row -->
        <br/>
        <div class="row">
            <div class="col-lg-8">
                <div class="input-group input-group-sm">
                      <span class="input-group-addon">
                        Slowa kluczowe EN
                      </span>
                      <input type="text" id="keyWordsEN" class="form-control" aria-label="..." placeholder="">
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </div> <!-- /row -->
        <br/>
        <button type="button" id="save" class="btn btn-success">Zapisz</button>
        <button type="button" id="detele" class="btn btn-danger">Usun</button>
    </span>
            </span>
    </div>
</div>
