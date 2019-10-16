<%@ page session="false" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<jsp:include page="/WEB-INF/views/header.jsp"/>
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
          <h1 class="page-header title">잡담 게시판</h1>
			
          <div class="row placeholders myscorll" id="content">
          	<table class="table table-hover">
		<colgroup>
			<col style="width:5%;" />
			<col style="width:auto;"/>
			<col style="width:auto;" />
			<col style="width:15%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
		</colgroup>

<thead>
<tr>	
		  <th>글번호</th>
		  <th>카테고리</th>
          <th>제목</th>
          <th>글쓴이</th>
          <th>조회수</th>
          <th>작성일</th>
</tr>
</thead>
<!-- 데이터베이스에서 불러올 글목록들 -->
<tbody>
<c:choose>
<c:when test="${empty boardList}">
		<tr><td colspan="6" align="center">데이터가 없습니다.</td></tr>
</c:when>
<c:when test="${!empty boardList}">
	<c:forEach var="list" items="${boardList}">
        <tr>
          <td>${list.bid}</td>
          <td>${list.cate_cd}
          <td><a href="#" onClick="fn_contentView(<c:out value="${list.bid}"/>)">${list.title}</a></td>
          <td>${list.reg_id}</td>
          <td>${list.view_cnt}</td>
          <td>${list.reg_dt}</td>
        </tr>
       </c:forEach>
       </c:when>
       </c:choose>
      </tbody>
      </table>
     <div>
     <button type="button" class="btn btn-sm btn-primary" id="btnWriteForm">글쓰기</button>
     
     </div>     	
          </div>

         
          
</div>
</div>

</div>
</body>
</html>
