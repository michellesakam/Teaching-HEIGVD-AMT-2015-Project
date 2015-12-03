<%@include file="choiceWidget.jsp" %>
<div ng-controller="WidgetLevelsController">
    <h2>Widget Levels</h2>
    
    <p>Current level : {{statsLevel.currentLevelName}}</p>
    <p>Points : {{statsLevel.currentPoints}} / {{statsLevel.nextLevelPoints}}</p>
    <p>Next Level : {{statsLevel.nextLevelName}}
</div>