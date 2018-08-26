angular.module('customer-create')
    .controller('CustomerCreateController', function (customerService, $location) {

        var vm = this;

        vm.customer = {};

        vm.create = create;

        function create() {
            customerService.create(vm.customer)
                .then(function () {
                    $location.path('/customers');
                })
                .catch(function (response) {
                    vm.errors = response.data;
                    console.log(response);
                })
        }

    });