<%@include file="choiceWidget.jsp" %>
<div ng-controller="WidgetBadgesController">
    <h2>Widget Badges</h2>

    <ul>
        <div ng-repeat="badge in badges">
            <li>{{ badge.name}}</li>
        </div>
    </ul>


</div>