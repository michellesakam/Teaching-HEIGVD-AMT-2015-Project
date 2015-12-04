(function () {

    var module = angular.module('gamification_app', ['ui.router', 'chart.js']);

    module.config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise('/start');

        $stateProvider
                .state('start', {
                    url: '/start',
                    templateUrl: '/GamificationProject/demoWidgets?view=start',
                })
                .state('widgetBadges', {
                    url: '/widgetBadges',
                    templateUrl: '/GamificationProject/demoWidgets?view=widgetBadges'
                })
                .state('widgetPoints', {
                    url: '/widgetPoints',
                    templateUrl: '/GamificationProject/demoWidgets?view=widgetPoints'
                })
                .state('widgetLevels', {
                    url: '/widgetLevels',
                    templateUrl: '/GamificationProject/demoWidgets?view=widgetLevels'
                });

    });
    
    module.controller('MainController', function($scope, $state) {
    });
    
    module.controller('WidgetLevelsController', function($scope, $http) {
        
        alert($scope.apiKey);
        
        // Fake data : replace with ajax request
        $scope.statsLevel = {
            currentLevelName: "Soldat",
            currentPoints: 132,
            nextLevelName: "Sergent",
            nextLevelPoints: 500
        };
        
    });
    
    module.controller('WidgetPointsController', function($scope, $http) {        
        
        $scope.labels = [
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"            
        ];
        
        // Fake data
        $scope.statsPoint = {
            
            totalPoints: 1503,
            totalInYear: 102,
            
            awards: [
                {month:8, points:56},
                {month:3, points:85},
                {month:11, points:102},
                {month:4, points:205},
                {month:9, points:85}
            ]
        };
        
        $scope.data = [
            function() {
                var data = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
                
                $scope.statsPoint.awards.forEach(function(e) {
                    data[e.month - 1] += e.points;
                });
                
                return data;
            }()
        ];
        
        
    });
    
    module.controller('WidgetBadgesController', function($scope, $http) {
        
    });

})();