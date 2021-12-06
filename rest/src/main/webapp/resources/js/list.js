/**
 * list.jsp 스크립트
 */
$(function(){
	//전체 정보 가져오기
	$.getJSON({ // 조건도 주지 않고 바로 들어가는 구문
		url:'/book/rest-list',
		success:function(data){
			console.log(data);
			
			let str="";
			
			$.each(data,function(idx,element){
				str +="<tr>";
				str +="<td>"+element.code+"</td>";
				str +="<td><a href='"+element.code+"'class='move'>"+element.title+"</a></td>";
				str +="<td>"+element.writer+"</td><td>"+element.price+"</td>";
				str +="</tr>";
			})
			$("tbody").html(str);
		
		}
	}) 



	//이벤트 위임 - 책 하나 가져오기	
	$("tbody").on("click",".move",function(e){
		//a 태그 속성 중지
		e.preventDefault();
	
		//제목 클릭 시 href 값 가져오기
		let code = $(this).attr("href");

		// ajax(기본), $.getJSON() 
		$.getJSON({
			url: code,
			success:function(data){
				//console.log(data);
			
				let str = '<ul>';
			
				str += "<li>code :"+data.code+"</li>";
				str += "<li>title :"+data.title+"</li>";
				str += "<li>writer :"+data.writer+"</li>";
				str += "<li>price :"+data.price+"</li>";
				str += "</ul>";
		
				$("#result").html(str);
		}
	})
  })

	// 도서 삭제
	$("#delete").click(function(){
		$.ajax({
			url : "1200",
			type : 'delete',
			success:function(data){
				alert(data);
			},
			error:function(xhr,xhrStatus,error){
				alert(xhr.responseText);
			}
		})
	})

	// 도서 수정
	$('#update').click(function(){
		//보낼 데이터 자바스크립트 객체
		let param = {
			code:'1300',
			price:40000
		};

		$.ajax({
			url:'update',
			type:'put',
			contentType:'application/json', // json 형태로 보내는 것을 들어갈 때 updateDto로 가는데 Mapping을 RequestBody가 도와주는 형식
			data:JSON.stringify(param),
			success:function(data){
				alert(data);
			},
			error:function(xhr,xhrStatus,error){
				alert(xhr.responseText);
			}
		})
	})






})