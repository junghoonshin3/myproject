//게시판 쓰기 이벤트 처리 함수
$(document).on('click', '#btnWriteForm', function(e){
		
		location.href = "/gaepo/boardForm";

	});
//게시판 리스트 이벤트 처리 함수
$(document).on('click','#btnList', function(e){
		location.href="/gaepo/getBoardList";

		
	});
//게시판 content 클릭 이벤트 처리 함수
function fn_contentView(bid){
	var url="/board/getBoardContent";
	url= url+"?bid="+bid;
	location.href=url;
	
}