angular.module('customer-edit')
    .controller('CustomerEditController',function (customer, customerService, $location) {
        var vm = this;

        vm.customer = customer;

        vm.update = update;

        function update() {
            customerService.update(vm.customer)
                .then(function () {
                    $location.path('/customers');
                })
                .catch(function (response) {
                    vm.errors = response.data;
                })
        }

    });