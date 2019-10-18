//게시판 쓰기 이벤트 처리 함수
$(document).on('click', '#btnWriteForm', function(e){
		
		location.href = "/gaepo/boardForm";

	});
//게시판 리스트 이벤트 처리 함수
$(document).on('click','#btnList', function(e){
		location.href="/gaepo/getBoardList";

		
});
//게시판 수정 클릭 이벤트 처리 함수
$(document).on('click','#btnUpdate',function(){
	var url="/gaepo/editForm";
	url= url+"?bid="+$("#bid").val();
	url= url+"&mode=edit";
	location.href=url;
});
//게시판 수정 클릭 이벤트 처리 함수
$(document).on('click','#btnDelete',function(){
	var url="/gaepo/deleteBoard";
	url= url+"?bid="+$("#bid").val();
	location.href=url;
});
//게시판 content 클릭 이벤트 처리 함수
function fn_contentView(bid){
	var url="/gaepo/getBoardContent";
	url= url+"?bid="+bid;
	location.href=url;
	
}

