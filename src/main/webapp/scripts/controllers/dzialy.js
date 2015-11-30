'use strict';

angular.module('webApp').controller('DzialyCtrl', function($scope, $http, $route) {
	$http({
		method : 'GET',
		url : '/dzialy'
	}).then(function successCallback(response) {
		$scope.dzialy = response.data;

	}, function errorCallback(response) {
		alert('ups');
	});

	$scope.dzial = {};
	$scope.insertDzial = function() {
		$http({
			method : 'POST',
			url : '/dzialy',
			data : $scope.dzial
		}).then(function successCallback(response) {
			alert('Dodano');
			$route.reload();
		}, function errorCallback(response) {
			alert('ups');
		});
	};

});