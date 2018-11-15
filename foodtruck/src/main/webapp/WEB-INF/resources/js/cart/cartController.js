'use strict';

(function() {
	var app = angular.module('foodtruck');

	app.controller('cartCtrl', [ '$scope', 'menuService',
	function($scope, sessionService) {
		
		 $scope.sessionData = sessionService;
         $scope.varShowCart = true;
         sessionService.save($scope.sessionData);
		          }]);
	
})()
			