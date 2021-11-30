<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<form action="" method="post">
	<div class="form-group">
		<label for="code">code</label>
		<input type="text" name="code" id="code" class="form-control" readonly="readonly" value="${dto.code}"/>
	</div>
	<div class="form-group">
		<label for="title">title</label>
		<input type="text" name="title" id="title" class="form-control" readonly="readonly" value="${dto.title}"/>
	</div>
	<div class="form-group">
		<label for="writer">writer</label>
		<input type="text" name="writer" id="writer" class="form-control" readonly="readonly" value="${dto.writer}"/>
	</div>
	<div class="form-group">
		<label for="price">price</label>
		<input type="text" name="price" id="price" class="form-control" readonly="readonly" value="${dto.price}"/>
	</div>
	<button type="submit" class="btn-btn-primary">입력</button>
	<button type="reset" class="btn-btn-secondary">취소</button>
</form>
<%@ include file="../includes/footer.jsp"%>
