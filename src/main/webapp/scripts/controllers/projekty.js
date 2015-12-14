'use strict';

angular.module('webApp').controller('ProjektyCtrl', function($scope, $http, $route) {
	$http({
		method : 'GET',
		url : '/projekty'
	}).then(function successCallback(response) {
		$scope.projekty = response.data;

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
			alert('ups');
		});
	};

});