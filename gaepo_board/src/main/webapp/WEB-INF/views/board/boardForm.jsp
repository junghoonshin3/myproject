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
     <h1 class="page-header title">글쓰기</h1>
			
          <div class="row placeholders myscorll" id="content">
		<form action="/gaepo/saveBoard" method="post">
		<div class="form-group">
   	 	<label for="title">제목</label>
   		<input type="text" class="form-control" id= "title" name="title" placeholder="제목을 입력하세요">
 		 </div>
 		 <div class="form-group">
   	 	<label for="reg_id">아이디</label>
   		<input type="text" class="form-control" id= "reg_id" name="reg_id" placeholder="세션 id값" value="세션 id값" readonly>
 		 </div>
 	  <div class="form-group">
 	  <label for="cate_cd">카테고리</label>
      <select id="cate_cd" name="cate_cd" class="form-control" style="width:auto;">
        <option value="secret">은밀한 이야기</option>
        <option value="game">게임 이야기</option>
        <option value="etc">잡담</option>
      </select>
    
 		
 		</div>		 		 
 		
 		<div class="form-group">
   	 	<label for="content">내용</label>
   		<textarea rows="10" class="form-control" id="content" name="content" placeholder="내용을 입력하세요"></textarea>
 		 </div>
 		 <div class="form-group">
   	 	<label for="tag">태그</label>
   			<input type="text" class="form-control" id= "tag" name="tag" placeholder="태그를 입력하세요">
 		 </div>
		 <button type="submit" class="btn btn-default">등록</button>	
		 <button type="button" id="btnList" class="btn btn-default">목록</button>
		</form>

		</div>

         
          
</div>
</div>

</div>
</body>
</html>
