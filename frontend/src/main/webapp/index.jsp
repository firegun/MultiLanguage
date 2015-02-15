<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="masterpage" uri="http://masterpage.com/jsp-masterpage/" %>
<%@ page import="com.paristravel.googleplus.GooglePlusUtilities"%>

<!DOCTYPE html>
<html lang="fr" >
<%--ng-app="ApplicationApp"--%>
<head>
    <!-- meta -->
    <meta charset="utf-8" />
    <meta name="keywords" content="Tuto" />
    <meta name="description" content="Tuto" />
    <meta name="author" content="auteur">

    <!-- jsRequire library -->
    <script type="text/javascript" src="library/require.js"></script>
    <script type="text/javascript" src="js/app.js"></script>

    <%--<!-- jquery library -->--%>
    <script type='text/javascript' src="library/jquery/jquery-2.1.0.min.js"></script>

    <%--<!-- angular js library -->--%>
    <script type='text/javascript' src="library/angularjs/angular.min.js"></script>
    <script type='text/javascript' src="library/angularjs/angular-route.min.js"></script>
    <script type='text/javascript' src="library/angularjs/angular-resource.min.js"></script>
    <script type='text/javascript' src="library/angularjs/angular-animate.min.js"></script>

    <%--<!-- bootstrap js library -->--%>
    <script type="text/javascript" src="library/bootstrap/js/bootstrap.min.js"></script>

    <!-- google + library -->
    <%--<script type="text/javascript" src="library/google+/plus.js">--%>
        <%--// Définit les options de configuration :--%>
        <%--window.___gcfg = {--%>
            <%--lang: 'fr-FR',--%>
            <%--parsetags: 'onload'--%>
        <%--}--%>
    <%--</script>--%>
    <%--<script type="text/javascript" src="library/google+/client%20plus.js"></script>--%>

    <!-- personnal script files-->
    <script type="text/javascript" src="js/google/authgoogle.js"></script>

    <!-- CSS bootstrap -->
    <link rel="stylesheet" type="text/css" href="library/bootstrap/css/bootstrap.min.css">

    <!-- personnal CSS files -->
    <link rel="stylesheet" type="text/css" href="css/style.css" />

    <!-- metadata -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>ParisTravel</title>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        MultiLanguage
    </div>
</nav>

<div class="content container-fluid">

    <div class="menu">
        <%-- Google+ --%>
        <span id="signinButtonGPlus">
              <span
                  class="g-signin"
                  data-callback="signinCallback"
                  data-clientid="<%= GooglePlusUtilities.CLIENTID %>"
                  data-cookiepolicy="single_host_origin"
                  data-requestvisibleactions="http://schemas.google.com/AddActivity"
                  data-scope="https://www.googleapis.com/auth/plus.login">
              </span>
        </span>
        <%-- twitter --%>
        <% if(request.getSession().getAttribute("accessToken") != null) { %>
            <span class="disable">
        <% } else {%>
            <span>
        <%}%>
            <button id="buttonTwitter" ><img src="img/sign-in-with-twitter-gray.png"></button>
        </span>
    </div>
    <div class="clear"/>
    <masterpage:placeholder name="body"/>
</div>
</body>
</html>
