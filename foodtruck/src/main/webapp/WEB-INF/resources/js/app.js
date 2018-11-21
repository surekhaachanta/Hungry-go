(function() {
	var app = angular.module('foodtruck', [ 'ui.router', 'oc.lazyLoad' ]);

	app
			.config(function($stateProvider, $urlRouterProvider) {

				$urlRouterProvider.otherwise('/home');

				$stateProvider
						.state('home', {
							url : '/home',
							templateUrl : 'resources/templates/homepage.html'
						})
						.state(
								'menu',
								{
									url : '/menu',
									templateUrl : 'resources/templates/menu.html',
									resolve : {
										loadFiles : [
												'$ocLazyLoad',
												function($ocLazyLoad) {
													return $ocLazyLoad
															.load([ {
																name : 'menu.ctrl',
																files : [
																		'resources/css/menu.css',
																		'resources/js/menu/menuService.js',
																		'resources/js/menu/menuController.js' ],
																cache : false
															} ]);
												} ]
									}
								})
						.state('contact', {
							url : '/contact',
							templateUrl : 'resources/templates/contact.html'
						})
						.state('about', {
							url : '/about',
							templateUrl : 'resources/templates/aboutus.html'
						})
						.state('checkout', {
							url : '/checkout',
							templateUrl : 'resources/templates/checkout.html'
						})
						.state(
								'orderSuccess',
								{
									url : '/orderSuccess',
									templateUrl : 'resources/templates/orderSuccess.html'
								})
						.state(
								'cart',
								{
									url : '/cart',
									templateUrl : 'resources/templates/cart.html',
									resolve : {
										loadFiles : [
												'$ocLazyLoad',
												function($ocLazyLoad) {
													return $ocLazyLoad
															.load([ {
																name : 'cart.ctrl',
																files : [
																		'resources/css/app.css',
																		'resources/js/cart/cartService.js',
																		'resources/js/cart/cartController.js' ],
																cache : false
															} ]);
												} ]
									}

								});

			});

	app.service('appService', [ '$http', '$q', function($http, $q) {
		this.login = function(userName, password) {
			var defer = $q.defer();
			var data = {
				userName : userName,
				password : password
			}
			$http.post('/user/login', data).then(function success(res) {
				console.log("check here" + res.data);
				if (res.data)
					defer.resolve(res.data);
				else
					{
					
					defer.reject();
					}
			});
			return defer.promise;
		};

		this.register = function(formData) {
			var defer = $q.defer();
			$http.post('/user/register', formData).then(function(res) {
				defer.resolve(res.data);
				console.log(res.data + "bbbb");
			}, function() {
				defer.reject();
			});
			return defer.promise;
		}
	} ]);

	app.controller('mainCtrl', [
			'$scope',
			'appService',
			'$window',
			'$state',
			function($scope, appService, $window, $state) {
				$scope.login = true;
				$scope.register = true;
				$scope.userLoggedIn = false;
				$scope.loginError= false;
				$scope.login = function(user) {

					appService.login(user.userName, user.password).then(
							function success(res) {
								$scope.userLoggedIn = true;
								$scope.login = false;
								$scope.register = false;
								$scope.userName = user.userName;
								$scope.loginError=false;

							}, function failed(error) {
								$scope.userLoggedIn = false;
								$scope.loginError=true;
							});

				};

				$scope.register = function(newUser) {
					$scope.userName = newUser.userName;
					var payload = {
						userName : newUser.userName,
						email : newUser.email,
						password : newUser.password
					};
					console.log(payload);
					appService.register(payload).then(function(res) {
						$scope.userLoggedIn = true;
						$scope.login = false;
						$scope.register = false;
					});

				}
			} ]);
})();