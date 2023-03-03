<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Register File</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<body>
	<h1>Ajax Register File</h1>
	<hr>
	
	<h3>★★★★10. 파일업로드 Ajax 방식 요청 처리★★★★</h3>
	<hr><br>
	
	<h3>1) Ajax 방식으로 전달한 파일 요소값을 스프링 MVC가 지원하는 MultipartFile 매개변수로 처리한다.</h3>
	<div>
		<input type="file" id="inputFile"><br>
		<hr>
		<img alt="썸네일 이미지 확인" src="" id="preview">
	</div>
</body>
<script type="text/javascript">
$(function(){
	
	$("#inputFile").on("change", function(event){
		console.log("change event....!!")
		
		var files = event.target.files;
		var file = files[0];
		
		console.log(file);
		
		if(isImageFile(file)){	// 해당 파일이 이미지인지 체크
			
			// ajax로 파일을 컨트롤 시, formData를 이용한다.
			// append() 이용
			// key : value 형태로 값이 추가된다.
			var formData = new FormData();
			formData.append("file", file);
			formData.append("userId", file);
			formData.append("password", file);
			
			// formData는 key/value 형식으로 데이터가 저장된다.
			// dataType : 응답(response) 데이터를 내보낼 때 보내줄 데이터 타입입니다.
			// processData : 데이터 파라미터를 data라는 속성으로 넣는데, 제이쿼리 내부적으로 쿼리스트링을 구성합니다.
			// 				파일 전송의 경우 쿼리스트링을 사용하지 않으므로 해당 설정을 false합니다.
			// contentType : Content-Type을 설정 시, 사용하는데 해당 설정의 기본값은 
			//				"application/x-www-form-urlencoded; charset=utf-8"입니다.
			//				하여, 기본값으로 나가지 않고 "multipart/form-data"로 나갈 수 있도록 설정을 false합니다.
			// request 요청에서 Content-Type 을 확인해보면 "multipart/form-data; boundary=----WebkitFormBoundary7Taxt434B
			// 와 같은 값으로 전송된 것을 확인할 수 있습니다.
			
			$.ajax({
				type : "post",
				url : "/ajax/uploadAjax",
				data : formData,
				dataType : "text",
				processData : false,	// 비동기 처리 시, 꼭 false로
				contentType : false,	// 비동기 처리 시, 꼭 false로
				success : function(data){
					alert(data);
					
					if(data == "UPLOAD SUCCESS"){
						var file = event.target.files[0];
						var reader = new FileReader();
						reader.onload = function(e){
							// src에 경로를 셋팅한다.
							$("#preview").attr("src", e.target.result);
						}
						// 최종 이미지가 출력되면, 이미지는 경로가 출력되지만 실제로는 base64인코딩 설정에 의한
						// 이미지 데이터가 출력된다.
						reader.readAsDataURL(file);
					}
				}
			});
			
		}else {
			alert("이미지를 넣으란말야~~!!")
		}
	});
});

function isImageFile(file){
	var ext = file.name.split(".").pop().toLowerCase();	// 파일명에서 확장자를 가져옵니다.
	return ($.inArray(ext, ["jpg","jpeg","gif","png","bmp"]) == -1) ? false : true;
}

</script>
</html>