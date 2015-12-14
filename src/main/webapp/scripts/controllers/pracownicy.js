'use strict';


angular.module('webApp')
  .controller('PracownicyCtrl', function ($scope, $http, $route) {
	  $http({
		  method: 'GET',
		  url: '/pracownicy'
		}).then(function successCallback(response) {
		    $scope.pracownicy = response.data;
		    
		  }, function errorCallback(response) {
		    alert('ups');
		  });
	  
	  $http({
			method : 'GET',
			url : '/dzialy'
		}).then(function successCallback(response) {
			$scope.dzialy = response.data;

		}, function errorCallback(response) {
		});
	  
	  $scope.pracownik = {};
		$scope.insertPracownik = function() {
			$http({
				method : 'POST',
				url : '/pracownicy',
				data : $scope.pracownik
			}).then(function successCallback(response) {
				alert('Dodano');
				$route.reload();
			}, function errorCallback(response) {
				alert('ups');
			});
		};
		
	
  });