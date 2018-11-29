(function () {
    var app = angular.module('foodtruck');

    app.service('adminMenuService', ['$http', '$q', function ($http, $q) {

        this.deleteItem = function (menuItem) {
            var defer = $q.defer();
            $http.delete('/menu/item/' + menuItem.id).then(function (res) {
                defer.resolve(res.data);
            }, function () {
                defer.reject();
            });
            return defer.promise;
        };

        this.createItem = function (payload) {
            var defer = $q.defer();
            $http.put('/menu/item', payload).then(function (res) {
                defer.resolve(res.data);
            }, function () {
                defer.reject();
            });
            return defer.promise;
        };
    }]);
})();