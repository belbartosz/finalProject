angular.module('carrier-edit')
    .config(function ($routeProvider) {
        $routeProvider.when('/carriers/edit/:carrierId',{
            templateUrl: '/carrier-edit/carrier-edit.html',
            controller: 'CarrierEditController',
            controllerAs: 'vm',
            resolve: {
                carrier: function (carrierService, $route) {
                    return carrierService.get($route.current.params.carrierId);
                }
            }
        });
    });