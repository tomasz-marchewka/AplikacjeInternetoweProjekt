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
		  method: 'GET',
		  url: '/dzialy'
		}).then(function successCallback(response) {
		    $scope.dzialy = response.data;
		    
		  }, function errorCallback(response) {
		    alert('ups');
		  });
	  
	  //pobieranie projektow
	  $http({
		  method: 'GET',
		  url: '/projekty'
		}).then(function successCallback(response) {
		    $scope.projekty = response.data;
		    
		  }, function errorCallback(response) {
		    alert('ups');
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
		
		
		$scope.deletePracownik = function(id) {
			$http({
				method : 'DELETE',
				url : '/pracownicy/' + id.toString(),
			}).then(function successCallback(response) {
				$route.reload();
			}, function errorCallback(response) {
				alert('ups');
			});
		};
  });