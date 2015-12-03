(function () {

    var module = angular.module('gamification_app', ['ui.router', 'chart.js']);

    module.config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise('/start');

        $stateProvider
                .state('start', {
                    url: '/start',
                    templateUrl: '/GamificationProject/demoWidgets?view=start',
                    controller: 'StartController'
                })
                .state('widgetBadges', {
                    parent: 'start',
                    url: '/widgetBadges',
                    templateUrl: '/GamificationProject/demoWidgets?view=widgetBadges',
                    controller: 'WidgetBadgesController'
                })
                .state('widgetPoints', {
                    parent: 'start',
                    url: '/widgetPoints',
                    templateUrl: '/GamificationProject/demoWidgets?view=widgetPoints',
                    controller: 'WidgetPointsController'
                })
                .state('widgetLevels', {
                    parent: 'start',
                    url: '/widgetLevels',
                    templateUrl: '/GamificationProject/demoWidgets?view=widgetLevels',
                    controller: 'WidgetLevelsController'
                });

    });
    
    module.controller('StartController', function($scope, $state) {
        
        $scope.showWidgets = function() {
            $('div #startWidgets').fadeOut();
            $state.go('widgetBadges');
        };
    
    });
    
    module.controller('WidgetLevelsController', function($scope, $http) {
    });
    
    module.controller('WidgetPointsController', function($scope, $http) {
    });
    
    module.controller('WidgetBadgesController', function($scope, $http) {
    });

})();