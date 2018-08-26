angular.module('carrier-create')
    .controller('CarrierCreateController', function (carrierService, $location) {

        var vm = this;

        vm.carrier = {};

        vm.create = create;

        function create() {
            carrierService.create(vm.carrier)
                .then(function () {
                    $location.path('/carriers');
                })
                .catch(function (response) {
                    vm.errors = response.data;
                    console.log(response);
                })
        }

    });