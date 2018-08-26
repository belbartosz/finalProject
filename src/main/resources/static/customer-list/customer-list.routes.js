var customerListModule = angular.module('customer-list');

customerListModule.config(function ($routeProvider) {
    $routeProvider.when('/customers',{
        templateUrl: '/customer-list/customer-list.html',
        controller: 'CustomerListController',
        controllerAs: 'vm'

    })
});