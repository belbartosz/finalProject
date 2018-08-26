angular.module('customer')
    .service('customerService', function ($resource) {

        var service = this;

        var customerResource =  $resource('http://localhost:8080/customers/:customerId',{},{
            query: {
                method: 'GET',
                isArray: true,
                url: 'http://localhost:8080/customers/allCustomers'
            },
            update: {
                method: 'PUT'
            }
        });

        service.search = function (params) {
            return customerResource.query(params).$promise;
        };

        service.create = function (customer) {
            return customerResource.save({},customer).$promise
        };

        service.remove = function (customerId) {
            return customerResource.remove({customerId: customerId}).$promise
        }

        service.get = function (id) {
            return customerResource.get({
                customerId: id
            }).$promise;
        };

        service.update = function (customer) {
            return customerResource.update(
                {
                    customerId: customer.id
                },
                customer).$promise;
        }
    });