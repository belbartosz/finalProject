var portListModule = angular.module('port-list');

portListModule.config(function ($routeProvider) {
    $routeProvider.when('/ports',{
        templateUrl: '/port-list/port-list.html',
        controller: 'PortListController',
        controllerAs: 'vm'

    })
});