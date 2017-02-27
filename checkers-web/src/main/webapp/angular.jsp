<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->

   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/semantic.min.css" />
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
  <body id="example" class="site" ng-app="puissance4AngularApp" ng-controller="MainCtrl">
  <script type="text/javascript">
    var apiEndpoint = '${pageContext.request.contextPath}/api/';
  </script>

    <div class="ui fixed inverted main menu">
        <div class="container">
            <div class="title item">
                <b>Checkers</b>
            </div>
        </div>
    </div>


   <div id="header" class="header segment">
        <div class="container">
            <h2 class="ui dividing header">Checkers</h2>
            <div class="introduction">
                <p>Simple Checkers app that makes use of JEE servlets</p>
            </div>

              <div ng-show="game.winner != 'NULL'" id="winner" ng-class="{massive:true, circular:true, ui:true, icon:true,  button:true}">
               {{game.winner}} WON
              </div>


        </div>
    </div>

    <div class="main container">
      <div id="board" class="ui ten row padded grid">
          <a ng-repeat="r in game.row track by $index" class="blue row">
            <div ng-repeat="col in r.cols track by $index"  ng-click="cellClick($parent.$index , $index)"
            ng-class="{massive:true, circular:true, ui:true, icon:true, black:col=='BLACK', yellow:col=='WHITE',  button:true}">
            </div>

          </a>
      </div>
      
      <p ng-show="srcRow != undefined")>Move from {{srcRow}} - {{srcCol}} to {{destRow}} - {{destCol}} 
                  <a ng-click="playMove()" class="ui green button" id="play">Play Move</a>
                  <a ng-click="cancelMove()" class="ui green button" id="cancel">Cancel Move</a>
      </p>
      <a ng-click="resetGame()" class="ui red button" id="reset">Reset game</a>
    </div>





    <script src="${pageContext.request.contextPath}/scripts/angular.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/main.js"></script>

</body>
</html>
