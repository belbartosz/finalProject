angular.module('container-create')
    .config(function ($routeProvider) {
        $routeProvider.when('/containers/add', {
            templateUrl: '/container-create/container-create.html',
            controller: 'ContainerCreateController',
            controllerAs: 'vm',
            resolve: {
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