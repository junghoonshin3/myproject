<%@ page session="false" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
     <h1 class="page-header title">글쓰기</h1>
			
          <div class="row placeholders myscorll" id="content">
		<form:form modelAttribute="boardVO" action="/gaepo/saveBoard" method="post">
		<div class="form-group">
		<form:hidden id="bid" path="bid"/>
		<input type="hidden" name="mode"/>
   	 	<label for="title">제목</label>
   		<form:input type="text" class="form-control" id= "title" path="title" placeholder="제목을 입력하세요"/>
 		 </div>
 		 <div class="form-group">
   	 	<label for="reg_id">아이디</label>
   		<form:input type="text" class="form-control" id= "reg_id" path="reg_id"/>
 		 </div>
 	  <div class="form-group">
 	  <label for="cate_cd">카테고리</label>
      <form:select id="cate_cd" path="cate_cd" class="form-control" style="width:auto;">
        <form:option value="secret" label="은밀한 이야기"/>
        <form:option value="game" label="게임 이야기"/>
        <form:option value="etc" label="잡담"/>
      </form:select>
    </div>		 		 
 		
 		<div class="form-group">
   	 	<label for="content">내용</label>
   		<form:textarea rows="10" class="form-control" id="content" path="content" placeholder="내용을 입력하세요"></form:textarea>
 		 </div>
 		 <div class="form-group">
   	 	<label for="tag">태그</label>
   			<form:input type="text" class="form-control" id= "tag" path="tag" placeholder="태그를 입력하세요"/>
 		 </div>
		 <button type="submit" class="btn btn-default">등록</button>	
		 <button type="button" id="btnList" class="btn btn-default">목록</button>
		</form:form>

		</div>

         
          
</div>
</div>

</div>
<script>
$(document).ready(function(){
	var mode = '<c:out value="${mode}"/>';
	if ( mode == 'edit'){
		//입력 폼 셋팅
		$("#reg_id").prop('readonly', true);
		$("input:hidden[name='bid']").val('<c:out value="${boardContent.bid}"/>');
		$("input:hidden[name='mode']").val('<c:out value="${mode}"/>');
		$("#cate_cd").val('<c:out value="${boardContent.cate_cd}"/>');
		$("#reg_id").val('<c:out value="${boardContent.reg_id}"/>');
		$("#title").val('<c:out value="${boardContent.title}"/>');		
		$("#tag").val('<c:out value="${boardContent.tag}"/>');
	}
});
</script>
</body>
</html>