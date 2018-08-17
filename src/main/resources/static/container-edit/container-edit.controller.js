angular.module('container-edit')
    .controller('ContainerEditController',function (container, containerService, $location) {
        var vm = this;

        vm.container = container;

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