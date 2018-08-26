angular.module('customer-edit')
    .config(function ($routeProvider) {
        $routeProvider.when('/customers/edit/:customerId',{
            templateUrl: '/customer-edit/customer-edit.html',
            controller: 'CustomerEditController',
            controllerAs: 'vm',
            resolve: {
                customer: function (customerService, $route) {
                    return customerService.get($route.current.params.customerId);
                }
            }
        });
    });