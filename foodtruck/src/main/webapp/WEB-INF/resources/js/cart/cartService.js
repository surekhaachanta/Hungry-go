(function () {
    var app = angular.module('foodtruck');

    app.service('cartService', ['$http', '$q', function ($http, $q) {
    	 this.submitOrder = function (payload) {
             var defer = $q.defer();
             $http.post('/menu/order', payload).then(function (res) {
                 defer.resolve(res.data);
             }, function () {
                 defer.reject();
             })
             return defer.promise;
         }
    	} ])
})()