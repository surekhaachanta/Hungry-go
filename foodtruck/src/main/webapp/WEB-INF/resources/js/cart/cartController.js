'use strict';

(function() {
	var app = angular.module('foodtruck');

	app.controller('cartCtrl', [
			'$scope',
			'cartService',
			'$window',
			'$state',
			function($scope, service, $window, $state) {
				$scope.cartss = [];
				$scope.carts = [];
				console.log("in cart");
				$scope.varShowCart = true;
				$scope.cartss = JSON.parse($window.sessionStorage
						.getItem("cart"));
				var items = [];
				if ($scope.cartss != null) {
					$scope.cartss.forEach(function(item) {
						items.push(item);
					});
				}
				console.log(items);
				$scope.carts = items;

				$scope.getTotal = function() {
					$scope.cartss = JSON.parse($window.sessionStorage
							.getItem("cart"));
					var total = 0;
					total = _.reduce($scope.cartss, function(sum, item) {
						return sum + $scope.getCost(item);
					}, 0);
					console.log('total: ' + total);
					$window.sessionStorage.setItem("total", JSON
							.stringify(total));
					return total;
				};

				$scope.getTotalCount = function() {
					$scope.cartss = JSON.parse($window.sessionStorage
							.getItem("cart"))
							|| [];
					var count = 0;
					for (var i = 0; i < $scope.cartss.length; i++) {
						var item = $scope.cartss[i];
						count += $scope.toNumber(item.qty);
					}
					console.log(count);
					return count;
				}

				var findItemById = function(items, id) {
					return _.find(items, function(item) {
						return item.id === id;
					});
				};

				$scope.changeQty = function(itemToAdd) {
					var found = findItemById($scope.cartss, itemToAdd.id);
					if (found) {
						found.qty += itemToAdd.qty;
						$window.sessionStorage.setItem("cart", JSON
								.stringify($scope.carts));

					}
				}

				$scope.toNumber = function(value) {
					value = value * 1;
					return isNaN(value) ? 0 : value;
				}

				$scope.getCost = function(item) {
					return item.qty * item.price;
				};

				$scope.clearCart = function() {
					$scope.carts.length = 0;
					$window.sessionStorage.setItem("cart", JSON
							.stringify($scope.carts));

				};

				$scope.removeItem = function(item) {
					var index = $scope.carts.indexOf(item);
					$scope.carts.splice(index, 1);
					$window.sessionStorage.setItem("cart", JSON
							.stringify($scope.carts));
				};

				$scope.submitOrder = function(order) {
					$scope.cartss = JSON.parse($window.sessionStorage
							.getItem("cart"))
							|| [];
					var total = JSON.parse($window.sessionStorage
							.getItem("total"));

					var orderInfo = '';
					for (var i = 0; i < $scope.cartss.length; i++) {
						var item = $scope.cartss[i];
						orderInfo = orderInfo + '['+item.title + ' '
								+ item.category + ' '
								+ $scope.toNumber(item.qty)+'] ';
					}
					console.log("infoo");
					console.log(orderInfo);
					var payload = {
						orderInfo : orderInfo,
						total : total,
						userName : order.Fname,
						phone : order.phone,
						address : order.address,
						status : 'pending'
					};
					console.log("payload");
					console.log(payload);
					console.log("hello");
					service.submitOrder(payload).then(function(res) {
						$state.go("orderSuccess");
						$scope.carts.length = 0;
						$window.sessionStorage.setItem("cart", JSON
								.stringify($scope.carts));
						});

				};
			} ]);

})()
