<h1>Welcome to the Gamification Demo</h1>
<p>Type an API Key and an EndUser Number to show some widgets</p>

<div class="form-horizontal">
    <label>Api Key : </label>
    <input type="text" ng-model="formData.apiKey" />

    <label>End User Number : </label>
    <input type="text" ng-model="formData.endUserNumber" />                

    api key: {{ formData.apiKey }}
    <button class="btn btn-primary" ui-sref="widgetBadges">Show Widgets</button>
</div>