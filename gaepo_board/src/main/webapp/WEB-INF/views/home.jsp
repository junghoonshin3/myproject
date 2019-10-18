<%@ page session="false" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
<jsp:include page="top.jsp" flush="false"/>
</div>
<div class="container-fluid">
<div class="row">
<div class="col-sm-3 col-md-2 sidebar subject">
<jsp:include page="left.jsp" flush="false"/>
</div>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header"></h1>
			
          <div class="row placeholders myscorll" id="content">
          	          	
          </div>

         
          
</div>
</div>

</div>
<!-- 커스텀js -->
<script type="text/javascript" src="resources/js/top.js" charset="utf-8"></script>
<script type="text/javascript" src="resources/js/image.js" charset="utf-8"></script>
<script type="text/javascript" src="resources/js/left.js" charset="utf-8"></script>
<script type="text/javascript" src="resources/js/board.js" charset="utf-8"></script>
</body>
</html>
