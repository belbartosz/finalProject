var containerListModule = angular.module('container-list');

containerListModule.config(function ($routeProvider) {
    $routeProvider.when('/containers',{
        templateUrl: '/container-list/container-list.html',
        controller: 'ContainerListController',
        controllerAs: 'vm'

    })
});