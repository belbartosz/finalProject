angular.module('container-edit')
    .controller('ContainerEditController',function (container, containerService, $location,  carriers, containerTypes, ports, containerStatuses, customers) {
        var vm = this;

        vm.container = container;

        vm.customers = customers;

        vm.carriers = carriers;

        vm.containerTypes = containerTypes;

        vm.ports = ports;

        vm.containerStatuses = containerStatuses;

        vm.update = update;

        function update() {
            containerService.update(vm.container)
                .then(function () {
                    $location.path('/containers');
                })
                .catch(function (response) {
                    vm.errors = response.data;
                })
        }

    });