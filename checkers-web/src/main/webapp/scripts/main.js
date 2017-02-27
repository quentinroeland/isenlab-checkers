'use strict';
angular.module('puissance4AngularApp', [])
  .controller('MainCtrl', ['$scope','$http','$location', function($scope,$http, $location) {
		$scope.srcRow = undefined;
		$scope.srcCol = undefined;
		$scope.destRow = undefined;
		$scope.destCol = undefined;

	  var url = $location.absUrl().split("/");
	  $scope.urlToken = url[url.length-1];
	  $http({url:apiEndpoint+$scope.urlToken,method:'GET'}).success(
	  function(data) {

    	  console.log(data);
    	  $scope.game=data;
      }
    );
	  
    $scope.play = function(srcRow, srcCol, destRow, destCol) {
  	  $http({url:apiEndpoint+$scope.game.token+"/"+srcCol +"/"+srcRow+"/"+destCol+"/"+destRow,
  		    method:'POST'}).success(
  		      function(data) {
  		    	  $scope.game=data;
  		      });
    };
    
    $scope.cellClick = function(row, col) {
    	if($scope.srcRow == undefined){
    		$scope.srcRow = row;
    		$scope.srcCol = col;
        	console.log("set src");    		
    	}else{
    		$scope.destRow = row;
    		$scope.destCol = col;
        	console.log("set dist");
    	}
    	console.log("cell clicked");
	};
	
	$scope.playMove = function(){
		$scope.play($scope.srcRow, $scope.srcCol, $scope.destRow, $scope.destCol);
	};
	
	$scope.cancelMove =function(){
		$scope.srcRow = undefined;
		$scope.srcCol = undefined;
		$scope.destRow = undefined;
		$scope.destCol = undefined;
	};
	

  }]) ;
