<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
</head>
<body>
	<div class="menubar" align="center">
		<ul>
			<li id="title"><a href="index.jsp" style="text-align: center">IJ's Gallery</a></li>
				<li id="storyboard">
					<a>게시판</a>
					<ul>
						<li>
							<a href="showoffList">귀요미들 사진첩</a>
						</li>
						<li>
							<a href="memoryList">추억 저장소?</a>
						</li>		
					</ul>
				<li id="introduce">
					<a>여기도 꾸밀 수 있겠지</a>
					<ul>
						<li>
							<a href="#">나중에 추가하면 돼</a>
						</li>
						<li>
							<a href="#">여기도 수정준비</a>
							<a href="#">지우자</a>
						</li>
					</ul>
				</li>
				
				<li id="login">
					<a>
						로그인!
					</a>
				</li>
				
				<li id="join">
					<a>
						회원가입!
					</a>
				</li>

		</ul>
		<img alt="배너용 사진" src="img/banner.jpg" width="1600px" height="300px"><br>
	</div>
	<input type = "hidden" value = "값">
	<div align="center">
   	
		<c:if test="${param.req == null }">
			<jsp:include page="./main/mainpage.jsp" />
		</c:if>
		<c:if test="${param.req == 'showoffList' }">
			<jsp:include page="./showoff/showoffList.jsp" />
		</c:if>
		<c:if test="${param.req == 'memoryList' }">
			<jsp:include page="./memory/memoryList.jsp" />
		</c:if>
		<c:if test="${param.req == 'writeMemory' }">
			<jsp:include page="./memory/memoryWriteForm.jsp" />
		</c:if>
		<c:if test="${param.req == 'writeMemoryPro' }">
			<jsp:include page="./memory/memoryWrite.jsp" />
		</c:if>
		<c:if test="${param.req == 'writeShowOff' }">
			<jsp:include page="./showoff/showoffWriteForm.jsp" />
		</c:if>
		<c:if test="${param.req == 'writeShowOffPro' }">
			<jsp:include page="./showoff/showoffWrite.jsp" />
		</c:if>		
		<c:if test="${param.req == 'memoryView' }">
			<jsp:include page="./memory/memoryView.jsp" />
		</c:if>
		<c:if test="${param.req == 'showoffView' }">
			<jsp:include page="./showoff/showoffView.jsp" />
		</c:if>		
	</div>
</body>
</html>
