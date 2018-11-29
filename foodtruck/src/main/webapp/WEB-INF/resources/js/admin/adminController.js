(function () {
    var app = angular.module('foodtruck');

    app.controller('adminCtrl', ['$scope', function ($scope) {
        $scope.hideParent = false;
    }]);
})();