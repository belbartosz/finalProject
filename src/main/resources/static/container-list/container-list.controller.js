var containerListModule = angular.module('container-list');

containerListModule.controller('ContainerListController', function (containerService, $location) {

    var vm = this;

    vm.sortOptions = [
        {
            displayName: 'Name ASC',
            value: 'name,asc'
        }, {
            displayName: 'Name DSC',
            value: 'name,dsc'
        }, {
            displayName: 'Price ASC',
            value: 'price,asc'
        }, {
            displayName: 'Price DSC',
            value: 'price,dsc'
        }
    ];

    vm.params = {};

    vm.search = search;
    vm.remove = remove;
    vm.edit = edit;

    search();

    function search() {
        containerService.search(vm.params)
            .then(function (response) {
                // vm.products = response.content;
                //   /\ dla Page zamiast listy
                vm.containers = response;
            })
            .catch(function (response) {
                // console.log(response);
                vm.error = response.data.message;
            });
    }

    function remove(containerId) {
        containerService.remove(containerId)
            .then(function () {
                search()
            })
    }

    function edit(id) {
        $location.path('/containers/edit/'+ id)
    }

});