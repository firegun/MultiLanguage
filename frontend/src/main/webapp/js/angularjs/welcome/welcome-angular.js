'use strict';

(function(){

    var ApplicationApp = angular.module('ApplicationApp');
    var ApplicationAppServices = angular.module('ApplicationAppServices');

    // Déclaration du controller BasicController pour le module ExampleApp
    ApplicationApp.controller('BasicController', function BasicController ($scope, $http, GetHomeTimeline) {
        $scope.List = [];

        GetHomeTimeline.get({},function(data) {
            $scope.List = $scope.List.concat(data);
        });
    });

})();
