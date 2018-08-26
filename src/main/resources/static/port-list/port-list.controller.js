var portListModule = angular.module('port-list');

portListModule.controller('PortListController', function (portService, $location) {

    var vm = this;

    vm.params = {};

    vm.search = search;
    vm.remove = remove;
    vm.edit = edit;

    search();

    function search() {
        portService.search(vm.params)
            .then(function (response) {
                vm.ports = response;
            })
            .catch(function (response) {
                vm.error = response.data.message;
            });
    }

    function remove(portId) {
        portService.remove(portId)
            .then(function () {
                search()
            })
    }

    function edit(portId) {
        $location.path('/ports/edit/'+ portId)
    }

});