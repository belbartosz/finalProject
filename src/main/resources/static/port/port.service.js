angular.module('port')
    .service('portService', function ($resource) {

        var service = this;

        var portResource =  $resource('http://localhost:8080/ports/:portId',{},{
            query: {
                method: 'GET',
                isArray: true,
                url: 'http://localhost:8080/ports/allPorts'
            },
            update: {
                method: 'PUT'
            }
        });

        service.search = function (params) {
            return portResource.query(params).$promise;
        };

        service.create = function (port) {
            return portResource.save({},port).$promise
        };

        service.remove = function (portId) {
            return portResource.remove({portId: portId}).$promise
        }

        service.get = function (id) {
            return portResource.get({
                portId: id
            }).$promise;
        };

        service.update = function (port) {
            return portResource.update(
                {
                    portId: port.id
                },
                port).$promise;
        }
    });