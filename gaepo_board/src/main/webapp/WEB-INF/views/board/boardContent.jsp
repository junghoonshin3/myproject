<%@ page session="false" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
<jsp:include page="/WEB-INF/views/top.jsp" flush="false"/>
</div>
<div class="container-fluid">
<div class="row">
<div class="col-sm-3 col-md-2 sidebar subject">
<jsp:include page="/WEB-INF/views/left.jsp" flush="false"/>
</div>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
     <h1 class="page-header title">글내용</h1>
			
          <div class="row placeholders myscorll" id="content">
		  
		
		 <button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>
		 <button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>
		 <button type="button" id="btnList" class="btn btn-default">목록</button>
		

		</div>

         
          
</div>
</div>

</div>
</body>
</html>
