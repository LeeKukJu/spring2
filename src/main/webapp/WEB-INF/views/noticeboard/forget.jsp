<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="login-box">
  <div class="card card-outline card-primary">
    <div class="card-header text-center">
      <p href="" class="h4"><b>아이디찾기</b></p>
    </div>
    <div class="card-body">
      <p class="login-box-msg">아이디 찾기는 이메일, 이름을 입력하여 찾을 수 있습니다.</p>
      <form action="" method="post">
        <div class="input-group mb-3">
          <input type="text" class="form-control" name="memEmail" id="memEmail" placeholder="이메일을 입력해주세요.">
        </div>
		<div class="input-group mb-3">
          <input type="text" class="form-control" name="memName" id="memName" placeholder="이름을 입력해주세요.">
        </div>
		<div class="input-group mb-3">
          <p>회원님의 아이디는 <font color="red" id="id"></font> 입니다.</p>
        </div>
        <div class="row">
          <div class="col-12">
            <button type="button" id="idFindBtn" class="btn btn-primary btn-block">아이디찾기</button>
          </div>
          <!-- /.col -->
        </div>
      </form>
   </div>
    <!-- /.login-card-body -->
  </div>
  <br/>
  <div class="card card-outline card-primary">
    <div class="card-header text-center">
      <p href="" class="h4"><b>비밀번호찾기</b></p>
    </div>
    <div class="card-body">
      <p class="login-box-msg">비밀번호 찾기는 아이디, 이메일, 이름을 입력하여 찾을 수 있습니다.</p>
      <form action="" method="post">
        <div class="input-group mb-3">
          <input type="text" class="form-control" name="memId" id="memId" placeholder="아이디를 입력해주세요.">
        </div>
		<div class="input-group mb-3">
          <input type="text" class="form-control" name="memEmail" id="memEmail2" placeholder="이메일을 입력해주세요.">
        </div>
		<div class="input-group mb-3">
          <input type="text" class="form-control" name="memName" id="memName2" placeholder="이름을 입력해주세요.">
        </div>
		<div class="input-group mb-3">
          <p>회원님의 비밀번호는 <font color="red" id="password"></font> 입니다.</p>
        </div>
        <div class="row">
          <div class="col-12">
            <button type="button" id="pwFindBtn" class="btn btn-primary btn-block">비밀번호찾기</button>
          </div>
        </div>
      </form>
    </div>
    <!-- /.login-card-body -->
  </div>
  <div class="card card-outline card-secondary">
    <div class="card-header text-center">
	  <h4>MAIN MENU</h4>
      <button type="button" id="loginBtn" class="btn btn-secondary btn-block">로그인</button>
    </div>
  </div>
</div>
<script type="text/javascript">
$(function() {
	var loginBtn = $("#loginBtn");
	var idFindBtn = $("#idFindBtn");
	var pwFindBtn = $("#pwFindBtn");
	
	loginBtn.on("click", function(){
		location.href = "/notice/login.do";
	})
	
	idFindBtn.on("click", function() {
		if($("#memEmail").val() == ""){
			alert("이메일을 입력해주세요.");
			return false;
		}
		if($("#memName").val() == ""){
			alert("이름을 입력해주세요.");
			return false;
		}
		
		$.ajax({
			type : "post",
			url : "/notice/idForget.do",
			data : {
				memEmail : $("#memEmail").val(),
				memName : $("#memName").val()
			},
			success : function(data){
				$("#id").html(data);
			}			
		});
	});
	
	pwFindBtn.on("click", function(){
		if($("#memId").val() == ""){
			alert("아이디를 입력해주세요.");
			return false;
		}
		if($("#memEmail2").val() == ""){
			alert("이메일을 입력해주세요.");
			return false;
		}
		if($("#memName2").val() == ""){
			alert("이름을 입력해주세요.");
			return false;
		}
		
		$.ajax({
			type : "post",
			url : "/notice/pwForget.do",
			data : {
				memId : $("#memId").val(),
				memEmail : $("#memEmail2").val(),
				memName : $("#memName2").val()
			},
			success : function(data){
				$("#password").html(data);
			}
		});
	});
});


</script>
