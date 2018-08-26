angular.module('carrier')
    .service('carrierService', function ($resource) {

        var service = this;

        var carrierResource =  $resource('http://localhost:8080/carriers/:carrierId',{},{
            query: {
                method: 'GET',
                isArray: true,
                url: 'http://localhost:8080/carriers/allCarriers'
            },
            update: {
                method: 'PUT'
            }
        });

        service.search = function (params) {
            return carrierResource.query(params).$promise;
        };

        service.create = function (carrier) {
            return carrierResource.save({},carrier).$promise
        };

        service.remove = function (carrierId) {
            return carrierResource.remove({carrierId: carrierId}).$promise
        }

        service.get = function (id) {
            return carrierResource.get({
                carrierId: id
            }).$promise;
        };

        service.update = function (carrier) {
            return carrierResource.update(
                {
                    carrierId: carrier.id
                },
                carrier).$promise;
        }
    });