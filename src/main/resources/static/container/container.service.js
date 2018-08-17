angular.module('container')
    .service('containerService', function ($resource) {

        var service = this;

        var containerResource =  $resource('http://localhost:8080/containers/:containerId',{},{
            query: {
                method: 'GET',
                isArray: true,
                url: 'http://localhost:8080/containers/searchContainers'
            },
            update: {
                method: 'PUT'
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
        }

        service.get = function (id) {
            return containerResource.get({
                containerId: id
            }).$promise;
        };

        service.update = function (container) {
            return containerResource.update(
                {
                    cobtainerId: container.id
                },
                container).$promise;
        }
    });