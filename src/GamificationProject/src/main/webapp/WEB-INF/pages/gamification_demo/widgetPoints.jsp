<%@include file="choiceWidget.jsp" %>
<div ng-controller="WidgetPointsController">
    <h2>Widget Points</h2>
    
    <div class="col-lg-8">
        <canvas id="bar" chart-data="data" chart-labels="labels" class="chart chart-bar" />          
        
        Total of points during the year : {{statsPoint.totalInYear}}

        <p><b>Total of points : {{statsPoint.totalPoints}}</b></p>        
        
    </div>

</div>