'use strict';

(function() {
	var app = angular.module('foodtruck');

	app.controller('cartCtrl', [ '$scope','$window',
	function($scope, $window) {
		 $scope.cartss = [];
		 $scope.carts = [];
		 console.log("in cart");
         $scope.varShowCart = true;
         $scope.cartss = JSON.parse($window.sessionStorage.getItem("cart"));
         var items = [];
         if( $scope.cartss!=null){
         $scope.cartss.forEach(function(item){
             items.push(item);
         });}
         console.log(items);
         $scope.carts = items;

         
         $scope.getTotal = function() {
        	 var total =0;
              total =  _.reduce($scope.carts, function(sum, item) {
               return sum + $scope.getCost(item);
             }, 0);
             console.log('total: ' + total);
             return total;
           };
           
           
           $scope.getCost = function(item) {
             return item.qty * item.price;
           };

           
           $scope.clearCart = function() {
             $scope.carts.length = 0;
             $window.sessionStorage.setItem("cart",JSON.stringify($scope.carts));

           };
           
           $scope.removeItem = function(item) {
             var index = $scope.carts.indexOf(item);
             $scope.carts.splice(index, 1);
             $window.sessionStorage.setItem("cart",JSON.stringify($scope.carts));
           };
		          }]);
	
})()
			