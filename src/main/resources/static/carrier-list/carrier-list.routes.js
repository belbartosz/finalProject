var carrierListModule = angular.module('carrier-list');

carrierListModule.config(function ($routeProvider) {
    $routeProvider.when('/carriers',{
        templateUrl: '/carrier-list/carrier-list.html',
        controller: 'CarrierListController',
        controllerAs: 'vm'

    })
});