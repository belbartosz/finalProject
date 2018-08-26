angular.module('port-create')
    .controller('PortCreateController', function (portService, $location) {

        var vm = this;

        vm.port = {};

        vm.create = create;

        function create() {
            portService.create(vm.port)
                .then(function () {
                    $location.path('/ports');
                })
                .catch(function (response) {
                    vm.errors = response.data;
                    console.log(response);
                })
        }

    });