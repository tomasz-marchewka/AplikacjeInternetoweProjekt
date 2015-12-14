'use strict';

angular.module('webApp').controller('ProjektyCtrl',
		function($scope, $http, $route) {
			$http({
				method : 'GET',
				url : '/projekty'
			}).then(function successCallback(response) {
				$scope.projekty = response.data;

			}, function errorCallback(response) {
				alert('ups 1 ');
			});

			$http({
				method : 'GET',
				url : '/dzialy'
			}).then(function successCallback(response) {
				$scope.dzialy = response.data;

			}, function errorCallback(response) {
				alert('ups');
			});

			$scope.projekt = {};
			$scope.insertProjekt = function() {
				$http({
					method : 'POST',
					url : '/projekty',
					data : $scope.projekt
				}).then(function successCallback(response) {
					alert('Dodano');
					$route.reload();
				}, function errorCallback(response) {
					alert('ups2');
				});
			};

			$scope.deleteProjekt = function(id) {
				$http({
					method : 'DELETE',
					url : '/projekty/' + id.toString()
				}).then(function successCallback(response) {
					$route.reload();
				}, function errorCallback(response) {
					alert('Błąd');
				});
			}
		});