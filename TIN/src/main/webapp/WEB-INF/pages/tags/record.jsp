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
        <span>Promotor</span>
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
        <div class="row">
            <div class="col-lg-3">
                <select class="form-control" id="issueDate">
                    <option value="1995">1995</option>
                    <option value="1996">1996</option>
                    <option value="1997">1997</option>
                    <option value="1998">1998</option>
                    <option value="1999">1999</option>
                    <option value="2000">2000</option>
                    <option value="2001">2001</option>
                    <option value="2002">2002</option>
                    <option value="2003">2003</option>
                    <option value="2004">2004</option>
                    <option value="2005">2005</option>
                    <option value="2006">2006</option>
                    <option value="2007">2007</option>
                    <option value="2008">2008</option>
                    <option value="2009">2009</option>
                    <option value="2010">2010</option>
                    <option value="2011">2011</option>
                    <option value="2012">2012</option>
                    <option value="2013">2013</option>
                    <option value="2014">2014</option>
                    <option value="2015">2015</option>
                    <option value="2016">2016</option>
                    <option value="2017">2017</option>
                    <option value="2018">2018</option>
                    <option value="2019">2019</option>
                </select>
            </div>
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
