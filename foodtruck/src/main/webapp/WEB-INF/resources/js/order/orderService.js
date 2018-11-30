(function () {
    var app = angular.module('foodtruck');

    app.service('orderService', ['$http', '$q', function ($http, $q) {
        this.getAllOrders = function () {
            var defer = $q.defer();
            console.log("in service");
            $http.get('/menu/orders').then(function (res) {
                defer.resolve(res.data);
            }, function () {
                defer.reject();
            })
            return defer.promise;
        };
        
        this.getAllCrews = function () {
            var defer = $q.defer();
            console.log("in service");
            $http.get('/menu/getCrews').then(function (res) {
                defer.resolve(res.data);
            }, function () {
                defer.reject();
            })
            return defer.promise;
        };
        
        
        this.changeStatus = function (order) {
            var defer = $q.defer();
            console.log("in c service");
            $http.post('/menu/status',order).then(function (res) {
                defer.resolve(res.data);
            }, function () {
                defer.reject();
            })
            return defer.promise;
        };
        
        this.changeTruck = function (order) {
            var defer = $q.defer();
            console.log("in order truck service");
            $http.post('/menu/changeTruck',order).then(function (res) {
                defer.resolve(res.data);
            }, function () {
                defer.reject();
            })
            return defer.promise;
        };
        
        this.changeCrew = function (crew) {
            var defer = $q.defer();
            console.log("in crew truck service");
            $http.post('/menu/changeCrew',crew).then(function (res) {
                defer.resolve(res.data);
            }, function () {
                defer.reject();
            })
            return defer.promise;
        }
    }])
})()