<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4-4.6.0/jq-3.6.0/dt-1.11.3/r-2.2.9/datatables.min.css"/>

    <script type="text/javascript" src="https://cdn.datatables.net/v/bs4-4.6.0/jq-3.6.0/dt-1.11.3/r-2.2.9/datatables.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>
</head>
<body>
<tiles:insertAttribute name="header"/>
<div class="container-fluid">
    <div class="row">
        <div class="border col-3"><tiles:insertAttribute name="menu"/></div>
        <div class="border col-9"><tiles:insertAttribute name="body"/></div>
    </div>
</div>
<tiles:insertAttribute name="footer"/>
</body>
</html>