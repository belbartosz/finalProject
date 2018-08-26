angular.module('container-edit')
    .config(function ($routeProvider) {
        $routeProvider.when('/containers/edit/:containerId',{
            templateUrl: '/container-edit/container-edit.html',
            controller: 'ContainerEditController',
            controllerAs: 'vm',
            resolve: {
                container: function (containerService, $route) {
                    return containerService.get($route.current.params.containerId);
                },
                containerTypes: function (containerService) {
                    return containerService.getContainerTypes();

                },
                carriers: function (carrierService) {
                    return carrierService.search();
                },
                ports: function (portService) {
                    return portService.search();
                },
                containerStatuses: function (containerService) {
                    return containerService.getContainerStatuses();
                },
                customers: function (customerService) {
                    return customerService.search();
                }
            }
        });
    });