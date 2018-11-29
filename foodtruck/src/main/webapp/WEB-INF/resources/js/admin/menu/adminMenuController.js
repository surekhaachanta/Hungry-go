(function () {
    var app = angular.module('foodtruck');

    app.controller('adminMenuCtrl', ['$scope', 'menuService', 'adminMenuService',
        function ($scope, menuService, adminMenuService) {
            $scope.menuItems = [];
            $scope.$parent.hideParent = true;
            $scope.select = {
                selected: {}
            };
            $scope.newItem = {};

            $scope.init = function () {
                menuService.getAllItems().then(function (res) {
                    $scope.menuItems = res;

                    $scope.select = {
                        selected: {}
                    };
                });
            };

            $scope.deleteConfirm = function (menuItem) {
                if (menuItem) {
                    console.log(menuItem);
                    bootbox.confirm({
                        message: "Are you sure you want to delete menu item : " + menuItem.category + ":-" + menuItem.title,
                        buttons: {
                            confirm: {
                                label: 'Yes',
                                className: 'btn-danger'
                            },
                            cancel: {
                                label: 'No',
                                className: 'btn-secondary'
                            }
                        },
                        callback: function (result) {
                            $scope.deleteItem(menuItem);
                        }
                    });
                }
            };

            $scope.deleteItem = function (menuItem) {
                console.log(menuItem);
                adminMenuService.deleteItem(menuItem).then(function (res) {
                    bootbox.alert('Successfully deleted the item');
                    $scope.init();
                });
            };

            $scope.createNewItem = function(newItemForm) {
                var payload = {
                    title: newItemForm.name.$viewValue,
                    price: newItemForm.price.$viewValue,
                    category: newItemForm.category.$viewValue
                }
                adminMenuService.createItem(payload).then(function (res) {
                    bootbox.alert('Successfully created the item');
                    $scope.init();
                });
            }

            $scope.init();
        }]);
})();