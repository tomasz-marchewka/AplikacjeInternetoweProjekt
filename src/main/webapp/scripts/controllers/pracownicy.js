'use strict';


angular.module('webApp')
  .controller('PracownicyCtrl', function ($scope, $http) {
	  $http({
		  method: 'GET',
		  url: 'http://localhost:8080/pracownicy'
		}).then(function successCallback(response) {
		    $scope.pracownicy = response.data;
		    
		  }, function errorCallback(response) {
		    alert('ups');
		  });
	  $scope.test = "asd";
  });