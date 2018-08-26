var customerListModule = angular.module('customer-list');

customerListModule.controller('CustomerListController', function (customerService, $location) {

    var vm = this;

    vm.params = {};

    vm.search = search;
    vm.remove = remove;
    vm.edit = edit;

    search();

    function search() {
        customerService.search(vm.params)
            .then(function (response) {
                vm.customers = response;
            })
            .catch(function (response) {
                vm.error = response.data.message;
            });
    }

    function remove(customerId) {
        customerService.remove(customerId)
            .then(function () {
                search()
            })
    }

    function edit(customerId) {
        $location.path('/customers/edit/'+ customerId)
    }

});