var carrierListModule = angular.module('carrier-list');

carrierListModule.controller('CarrierListController', function (carrierService, $location) {

    var vm = this;

    vm.params = {};

    vm.search = search;
    vm.remove = remove;
    vm.edit = edit;

    search();

    function search() {
        carrierService.search(vm.params)
            .then(function (response) {
                vm.carriers = response;
            })
            .catch(function (response) {
                vm.error = response.data.message;
            });
    }

    function remove(carrierId) {
        carrierService.remove(carrierId)
            .then(function () {
                search()
            })
    }

    function edit(carrierId) {
        $location.path('/carriers/edit/'+ carrierId)
    }

});