angular.module('container-create')
    .controller('ContainerCreateController', function (containerService, $location, carriers, containerTypes, ports, containerStatuses, customers) {

        var vm = this;

        vm.container = {};

        vm.customers = customers;

        vm.carriers = carriers;

        vm.containerTypes = containerTypes;

        vm.ports = ports;

        vm.containerStatuses = containerStatuses;

        vm.create = create;

        function create() {
            containerService.create(vm.container)
                .then(function () {
                    $location.path('/containers');
                })
                .catch(function (response) {
                    vm.errors = response.data;
                    console.log(response);
                })
        }

    });