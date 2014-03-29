'use strict';

(function(){

    // charger le module ngRoute et ExampleAppServices
    var ApplicationApp = angular.module('ApplicationApp', ['ngRoute','ngAnimate','ApplicationAppServices']);

    // utilisation du service routeProvider
    ApplicationApp.config(function routeProvider ($routeProvider){
        $routeProvider.
            when('/welcome',{
                templateUrl: 'js/angularjs/welcome/welcome-grid-template.html',
                controller: 'BasicController'
            }).
            otherwise({
                redirectTo: ''
            });
    });

    // Module de services
    var ApplicationAppServices = angular.module('ApplicationAppServices', ['ngResource']);

    ApplicationAppServices.factory('GetHomeTimeline',
        function ($resource){
            return $resource('http://127.0.0.1:8080/frontend/rest/twitter/homeTimeline',
                {},
                {
                    get: {method:'GET', isArray: true}
                }
            );
        }
    );

    ApplicationApp.directive('whenscrolled', function() {
        return function(scope, element, attrs) {
            var attributes = attrs.whenscrolled.split(',');
            var fonction = attributes[0];
            var source = attributes[1];
            $('.content').on('scroll',function(event){
                if($('.content').scrollTop()+$('.content').innerHeight()>=$('.content')[0].scrollHeight){

                }

                console.log($('.content').scrollTop());
                console.log($('.content')[0].scrollHeight);

                console.log($('.content').innerHeight());
            });
        };
    });

})();