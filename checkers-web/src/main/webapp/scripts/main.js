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
  		    method:'POST'}).then(function success(response) {
  		    	  $scope.game=response.data;
  		    	  $scope.cancelMove();
  		      }, function error(response){
  		    	  alert("Error : mouvement not possible");
  		    	  console.log(response);
  		      });
    };
    
    $scope.cellClick = function(row, col) {
    	if($scope.srcRow == undefined){
    		$scope.srcRow = row;
    		$scope.srcCol = col;		
    	}else{
    		$scope.destRow = row;
    		$scope.destCol = col;
    	}
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
	
	
	$scope.resetGame = function() {
		var redirectUrl = $location.absUrl().split("g/" + $scope.urlToken);
		window.location.href = redirectUrl[0];
	}

  }]) ;
