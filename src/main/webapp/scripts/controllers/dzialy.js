'use strict';


angular.module('webApp')
  .controller('DzialyCtrl', function ($scope, $http) {
	  $http({
		  method: 'GET',
		  url: 'http://localhost:8080/dzialy'
		}).then(function successCallback(response) {
		    $scope.dzialy = response.data;
		    
		  }, function errorCallback(response) {
		    alert('ups');
		  });
  });