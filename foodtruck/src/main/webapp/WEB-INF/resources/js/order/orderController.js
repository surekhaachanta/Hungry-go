(function() {
	var app = angular.module('foodtruck');
	app.controller('orderCtrl', [ '$scope', 'orderService',
			function($scope, service) {
				$scope.orders = [];
				$scope.crews = [];
				$scope.init = function() {
					console.log("in control");

					service.getAllCrews().then(function(res) {
						var crewmems = [];
						res.forEach(function(crw) {
							crewmems.push(crw);
						});
						$scope.crews = crewmems;
					});
					service.getAllOrders().then(function(res) {
						var ordrs = [];
						res.forEach(function(ordr) {
							if (ordr.status == "pending")
								ordrs.push(ordr);
						});
						$scope.orders = ordrs;
					});
				}
				$scope.init();
				$scope.visible = true;

				$scope.getTotalOrders = function() {
					var count = 0;
					for (var i = 1; i < $scope.orders.length + 1; i++) {
						count += i;
					}
					console.log(count);
					return count;
				};

				$scope.changeStatus = function(order) {
					var index = $scope.orders.indexOf(order);
					$scope.orders.splice(index, 1);
					order.status = "Completed";
					service.changeStatus(order).then(function(res) {
					});
				};

				$scope.changeTruck = function(order, selectTruck) {

					order.truck = selectTruck;
					console.log("truck change " + order.truck);
					service.changeTruck(order).then(function(res) {
					});
				};
				
				$scope.changeCrew = function(crew, ctruck) {
					console.log("hereeeeeeee " + ctruck);
					crew.truck = ctruck;
					console.log("crew change " + crew.truck);
					service.changeCrew(crew).then(function(res) {
					});
				};
			} ])
})()