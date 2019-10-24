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
//이전 버튼 이벤트

function fn_prev(page, range, rangeSize) {
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		var url = "/gaepo/getBoardList";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		location.href = url;
	}



  //페이지 번호 클릭

	function fn_pagination(page, range, rangeSize, searchType, keyword) {
		var url = "/gaepo/getBoardList";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		location.href = url;	
	}

	//다음 버튼 이벤트
	function fn_next(page, range, rangeSize) {
		var page = parseInt((range * rangeSize)) + 1;
		var range = parseInt(range) + 1;

		var url = "/gaepo/getBoardList";
		url = url + "?page=" + page;
		url = url + "&range=" + range;

		location.href = url;

	}


