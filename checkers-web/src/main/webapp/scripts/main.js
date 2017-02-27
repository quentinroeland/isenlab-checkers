'use strict';
console.log("test");
angular.module('puissance4AngularApp', [])
  .controller('MainCtrl', ['$scope','$http', function($scope,$http) {
	  console.log("test");
	  $http({url:apiEndpoint,method:'GET'}).success(
      function(data) {
    	  console.log("test");
    	  console.log(data);
    	  $scope.game=data;
      }
    );
    $scope.play = function(col) {
      $http(col.playAction).success(function(data) {$scope.game=data;});
    };

  }]) ;
