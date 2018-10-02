angular
    .module('core.item')
    .factory('userService', ['$http', function ($http) {
        var service = {};

        service.getItems = getItems;
        return service;

        function getItems() {
            return $http.get('http://localhost:8080/items')
                .then(handleSuccess, handleError('Error getting items'));
        }

       

        function handleSuccess(res) {
            return res.data;
        }

        function handleError(error) {
            return function () {
                return {success: false, message: error};
            };
        }
    }]);