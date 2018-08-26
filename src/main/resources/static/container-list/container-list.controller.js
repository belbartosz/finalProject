var containerListModule = angular.module('container-list');

containerListModule.controller('ContainerListController', function (containerService, $location) {

    var vm = this;

    vm.params = {};

    vm.search = search;
    vm.remove = remove;
    vm.edit = edit;

    search();

    function search() {
        containerService.search(vm.params)
            .then(function (response) {
                vm.containers = response;
            })
            .catch(function (response) {
                vm.error = response.data.message;
            });
    }

    function remove(containerId) {
        containerService.remove(containerId)
            .then(function () {
                search()
            })
    }

    function edit(containerId) {
        $location.path('/containers/edit/'+ containerId)
    }

});