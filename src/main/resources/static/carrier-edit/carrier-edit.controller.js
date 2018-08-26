angular.module('carrier-edit')
    .controller('CarrierEditController',function (carrier, carrierService, $location) {
        var vm = this;

        vm.carrier = carrier;

        vm.update = update;

        function update() {
            carrierService.update(vm.carrier)
                .then(function () {
                    $location.path('/carriers');
                })
                .catch(function (response) {
                    vm.errors = response.data;
                })
        }

    });