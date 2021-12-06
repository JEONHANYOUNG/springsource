/**
 * reply.jsp 스크립트
 */

// 자바스크립트 모듈화
let replyService = (function(){
	
	function add(reply,callback){
		console.log("add method 실행");
	
		$.ajax({
			url:'/replies/new',
			typ:'post',
			contentType:'application/json',
			data:JSON.stringify(reply),
			success:function(result){
				if(callback){ // 비동기식으로 움직이는 것이고 
					callback(result); //success가 넘어오고
				}
			}, error:function(xhr,status,err){
					error(err);
			}
			
		})
	}
	
	return {add:add};
	
})();

