(function () {
    var app = angular.module('foodtruck');

    app.controller('menuCtrl', ['$scope', 'menuService','$window','$timeout',function ($scope, service, $window,$timeout) {
        $scope.menuItems = {};

        $scope.init = function () {
            service.getAllItems().then(function (res) {
                var items = {};

                res.forEach(function(item){
                    if(!items[item.category]){
                        items[item.category] = [];
                    }

                    items[item.category].push(item);
                });

                $scope.menuItems = items;
            });
        }

        $scope.init();
        $scope.cart = [];
        
        var findItemById = function(items, id) {
            return _.find(items, function(item) {
              return item.id === id;
            });
          };
          
          
          $scope.addItem = function(itemToAdd) {
        	     $scope.showDiv = true;

        	  $timeout(function () {
        	      $scope.showDiv = false;
        	    }, 400)
        	    
          	console.log("here");
          	 $scope.cart= JSON.parse($window.sessionStorage.getItem("cart"))|| [];
            var found = findItemById($scope.cart, itemToAdd.id);
            if (found) {
              found.qty += itemToAdd.qty;
              $window.sessionStorage.setItem("cart",JSON.stringify($scope.cart));

            }
            else {
             
              $scope.cart.push(angular.copy(itemToAdd));
              console.log($scope.cart);
              $window.sessionStorage.setItem("cart",JSON.stringify($scope.cart));

            }

          };
 
    }])
})()