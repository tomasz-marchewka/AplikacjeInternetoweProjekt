'use strict';

/**
 * @ngdoc overview
 * @name webApp
 * @description
 * # webApp
 *
 * Main module of the application.
 */
angular
  .module('webApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/pracownicy', {
        templateUrl: 'views/pracownicy.html',
        controller: 'PracownicyCtrl'
      })
      .when('/dzialy', {
        templateUrl: 'views/dzialy.html',
        controller: 'DzialyCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
