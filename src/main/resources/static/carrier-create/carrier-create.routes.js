angular.module('carrier-create')
    .config(function ($routeProvider) {
        $routeProvider.when('/carriers/add', {
            templateUrl: '/carrier-create/carrier-create.html',
            controller: 'CarrierCreateController',
            controllerAs: 'vm'

        });
    });