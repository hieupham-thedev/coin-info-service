<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/lib/bootstrap/dist/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/lib/datatables.net-bs/css/dataTables.bootstrap.css"/>
    <script type="text/javascript" src="/lib/jquery/dist/jquery.js"></script>
    <script type="text/javascript" src="/lib/bootstrap/dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="/lib/datatables.net/js/jquery.dataTables.js"></script>
    <script type="text/javascript" src="/lib/datatables.net-bs/js/dataTables.bootstrap.js"></script>
</head>
<body>
<tiles:insertAttribute name="header"/>
<div class="container">
    <div class="row">
        <tiles:insertAttribute name="menu"/>
        <tiles:insertAttribute name="body"/>
    </div>
</div>
<tiles:insertAttribute name="footer"/>
</body>
</html>