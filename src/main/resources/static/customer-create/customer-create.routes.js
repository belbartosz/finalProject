angular.module('customer-create')
    .config(function ($routeProvider) {
        $routeProvider.when('/customers/add', {
            templateUrl: '/customer-create/customer-create.html',
            controller: 'CustomerCreateController',
            controllerAs: 'vm'

        });
    });