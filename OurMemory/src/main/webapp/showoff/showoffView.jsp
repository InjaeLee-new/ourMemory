<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="align-content: left;">
		<tr>
			<td rowspan="3">
				<img width="400" height="400" alt="" src="./img/${dto.board_file }" >
			</td>
			<td>
				<h1>글 제목 : ${dto.board_subject }</h1>
			</td>
			<td>
				조회수 : ${dto.board_hit }
			</td>
		</tr>
		
		<tr>
			<td>
				<h2>글 내용</h2>
				<p>${dto.board_content }</p>
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" onclick="location.href='showoff_recommendation?board_num=${dto.board_num}&pg=${pg }'" value="이 글을 추천해요!">
				<input type="button" onclick="location.href='showoff_notrecommendation?board_num=${dto.board_num}&pg=${pg }'" value="이 글이 싫어요!">
				<input type="button" onclick="location.href='showoffList?pg=${i }'" value="목록보기">
			</td>
		</tr>
	</table>
</body>
</html>