/**
 * read.jsp 스크립트
 */
$(function(){
	
	let form = $("#actionForm");
	
	//List를 클릭하면 전체 리스트 보여주기
	$(".btn-info").click(function(){
		location.href="/book/list";
	})
	
	//Modify를 클릭하면 actionForm 보내기
	// /board/modify + GET 
	$(function(){
		$(".btn-default").click(function(){
			form.attr("action","/board/modify");
			form.submit();
			
		})
	})
	
	
	
})

