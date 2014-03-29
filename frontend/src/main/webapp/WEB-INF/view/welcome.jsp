<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="masterpage" uri="http://masterpage.com/jsp-masterpage/" %>

<masterpage:master filename="/index.jsp">
    <masterpage:content placeholder="body">
        <script type="text/javascript" src="js/angularjs/welcome/welcome-angular.js"></script>
        <div ng-view class="views"></div>
    </masterpage:content>
</masterpage:master>
