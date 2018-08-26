angular.module('port-edit')
    .controller('PortEditController',function (port, portService, $location) {
        var vm = this;

        vm.port = port;

        vm.update = update;

        function update() {
            portService.update(vm.port)
                .then(function () {
                    $location.path('/ports');
                })
                .catch(function (response) {
                    vm.errors = response.data;
                })
        }

    });