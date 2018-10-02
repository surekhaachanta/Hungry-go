angular
    .module('userTable')
    .component('userTable', {
        templateUrl: "resources/templates/user-table.template.html",
        controller: ['$scope', 'userService',
            function UserTableController($scope, userService) {

                var self = this;
                this.items = [];

               

                this.fetchItems = function () {
                    userService.getItems()
                        .then(function (items) {
                            self.items = items;
                        });
                };
                this.fetchItems();

                
            }]

    });

