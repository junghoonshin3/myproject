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
		<div class="container">
		<div class="form-group">
   	 	<label for="title">제목</label>
   		<p class="form-control-static" id="title"><c:out value="${boardContent.title}"/></p>
 		 </div>
 		 <div class="form-group">
   	 	<label for="reg_id">아이디</label>
   		<p class="form-control-static" id="reg_id"><c:out value="${boardContent.reg_id}"/></p>
 		 </div>
 		 <div class="form-group">
   	 	<label for="cate_cd">카테고리</label>
   		<p class="form-control-static" id="cate_cd"><c:out value="${boardContent.cate_cd}"/></p>
 		 </div>
 		 <div class="form-group">
   	 	<label for="content">내용</label>
   		<p class="form-control-static" id="content"><c:out value="${boardContent.content}"/></p>
 		 </div>
 		 <div class="form-group">
   	 	<label for="tag">태그</label>
   		<p class="form-control-static" id="tag"><c:out value="${boardContent.tag}"/></p>
 		 </div>
 		<input type="hidden" id="bid" value="${boardContent.bid}"/>
		<button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>
		<button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>
		<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
		</div>
		</div>

         
          
</div>
</div>

</div>

</body>
</html>
