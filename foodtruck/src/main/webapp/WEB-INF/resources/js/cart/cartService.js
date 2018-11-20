(function () {
    var app = angular.module('foodtruck');

    app.service('cartService', ['$http', '$q', function ($http, $q) {
    	 this.submitOrder = function () {
             var defer = $q.defer();
             $http.get('/menu/order').then(function (res) {
                 defer.resolve(res.data);
             }, function () {
                 defer.reject();
             })
             return defer.promise;
         }
    	} ])
})()