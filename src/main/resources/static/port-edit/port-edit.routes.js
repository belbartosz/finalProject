angular.module('port-edit')
    .config(function ($routeProvider) {
        $routeProvider.when('/ports/edit/:portId',{
            templateUrl: '/port-edit/port-edit.html',
            controller: 'PortEditController',
            controllerAs: 'vm',
            resolve: {
                port: function (portService, $route) {
                    return portService.get($route.current.params.portId);
                }
            }
        });
    });