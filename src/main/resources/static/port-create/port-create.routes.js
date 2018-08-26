angular.module('port-create')
    .config(function ($routeProvider) {
        $routeProvider.when('/ports/add', {
            templateUrl: '/port-create/port-create.html',
            controller: 'PortCreateController',
            controllerAs: 'vm'

        });
    });