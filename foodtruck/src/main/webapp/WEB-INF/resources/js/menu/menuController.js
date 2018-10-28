(function () {
    var app = angular.module('foodtruck');

    app.controller('menuCtrl', ['$scope', 'menuService', function ($scope, service) {
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

        $scope.init()
    }])
})()