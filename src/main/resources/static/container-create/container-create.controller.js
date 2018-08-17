angular.module('container-create')
    .controller('ContainerCreateController', function (containerService, $location) {

        var vm = this;

        vm.container = {};

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