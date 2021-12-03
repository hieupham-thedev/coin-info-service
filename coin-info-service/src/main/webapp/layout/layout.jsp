<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/lib/bootstrap/dist/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/lib/datatables.net-bs4/css/dataTables.bootstrap4.css"/>
    <link rel="stylesheet" type="text/css" href="/lib/datatables.net-responsive-bs4/css/responsive.bootstrap4.css"/>
    <link rel="stylesheet" type="text/css" href="/lib/datatables.net-buttons-bs4/css/buttons.bootstrap4.css"/>
    <script type="text/javascript" src="/lib/jquery/dist/jquery.js"></script>
    <script type="text/javascript" src="/lib/bootstrap/dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="/lib/datatables.net/js/jquery.dataTables.js"></script>
    <script type="text/javascript" src="/lib/datatables.net-bs4/js/dataTables.bootstrap4.js"></script>
    <script type="text/javascript" src="/lib/datatables.net-responsive/js/dataTables.responsive.js"></script>
    <script type="text/javascript" src="/lib/datatables.net-responsive-bs4/js/responsive.bootstrap4.js"></script>
    <script type="text/javascript" src="/lib/sweetalert2/dist/sweetalert2.all.js"></script>
    <script type="text/javascript" src="/lib/datatables.net-buttons/js/dataTables.buttons.js"></script>
    <script type="text/javascript" src="/lib/datatables.net-buttons/js/buttons.html5.js"></script>
    <script type="text/javascript" src="/lib/datatables.net-buttons-bs4/js/buttons.bootstrap4.js"></script>

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