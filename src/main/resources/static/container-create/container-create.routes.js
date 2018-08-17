angular.module('container-create')
    .config(function ($routeProvider) {
        $routeProvider.when('/containers/add', {
            templateUrl: '/container-create/container-create.html',
            controller: 'ContainerCreateController',
            controllerAs: 'vm'

        });
    });