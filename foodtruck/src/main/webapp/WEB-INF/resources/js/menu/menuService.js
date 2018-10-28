(function () {
    var app = angular.module('foodtruck');

    app.service('menuService', ['$http', '$q', function ($http, $q) {
        this.getAllItems = function () {
            var defer = $q.defer();
            $http.get('/menu/items').then(function (res) {
                defer.resolve(res.data);
            }, function () {
                defer.reject();
            })
            return defer.promise;
        }
    }])
})()