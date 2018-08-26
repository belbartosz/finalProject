angular.module('container')
    .service('containerService', function ($resource) {

        var service = this;

        var containerResource =  $resource('http://localhost:8080/containers/:containerId',{},{
            query: {
                method: 'GET',
                isArray: true,
                url: 'http://localhost:8080/containers/allContainers'
            },
            update: {
                method: 'PUT'
            },
            getContainerTypes: {
                method: 'GET',
                isArray: true,
                url: 'http://localhost:8080/containers/containerTypes'
            },
            getContainerStatuses: {
                method: 'GET',
                isArray: true,
                url: 'http://localhost:8080/containers/containerStatuses'
            }

        });

        service.search = function (params) {
            return containerResource.query(params).$promise;
        };

        service.create = function (container) {
            return containerResource.save({},container).$promise
        };

        service.remove = function (containerId) {
            return containerResource.remove({containerId: containerId}).$promise
        };

        service.get = function (id) {
            return containerResource.get({
                containerId: id
            }).$promise
                .then(function(container) {
                    container.dateOfDischarge = new Date(container.dateOfDischarge);
                    container.dateOfLoading = new Date(container.dateOfLoading);
                    return container;
                });
        };

        service.update = function (container) {
            return containerResource.update(
                {
                    containerId: container.id
                },
                container).$promise;
        };

        service.getContainerTypes = function () {
            return containerResource.getContainerTypes().$promise;

        };

        service.getContainerStatuses = function () {
            return containerResource.getContainerStatuses().$promise;
        }
    });