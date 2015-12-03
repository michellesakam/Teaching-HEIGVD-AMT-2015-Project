<div ng-controller="MainController">
    <h1>Welcome to the Gamification Demo</h1>
    <p>Type an API Key and an EndUser Number to show some widgets</p>

    <div class="form-horizontal">
        <label>Api Key : </label>
        <input type="text" ng-model="apiKey" />

        <label>End User Number : </label>
        <input type="text" ng-model="endUserNumber" />                

        <button class="btn btn-primary" ui-sref="widgetBadges">Show Widgets</button>
    </div>
</div>