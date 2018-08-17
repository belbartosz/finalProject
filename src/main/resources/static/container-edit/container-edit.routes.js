angular.module('container-edit')
    .config(function ($routeProvider) {
        $routeProvider.when('/containers/edit/:containerId',{
            templateUrl: '/container-edit/container-edit.html',
            controller: 'ContainerEditController',
            controllerAs: 'vm',
            resolve: {
                container: function (containerService, $route) {
                    return containerService.get($route.current.params.containerId);
                }
            }
        });
    });