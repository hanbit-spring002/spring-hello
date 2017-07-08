<%@page import="com.hanbit.spring.core.vo.ArticleVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<ArticleVO> list = (List<ArticleVO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판</title>
	<link rel="stylesheet" href="https://unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css">
</head>
<body>
<table class="table">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>조회수</th>
			<th>날짜</th>
		</tr>
	</thead>
	<tbody>
		<% for (ArticleVO article : list) { %>
		<tr>
			<td><%=article.getNo() %></td>
			<td><%=article.getTitle() %></td>
			<td><%=article.getViews() %></td>
			<td><%=article.getUpdateDt() %></td>
		</tr>
		<% } %>
	</tbody>
</table>

<input type="text" id="txt-keyword">
<button id="btn-search">검색</button>

<div class="board-btns">
	<button class="btn btn-primary">글쓰기</button>
</div>
<script src="https://unpkg.com/jquery@3.2.1/dist/jquery.min.js"></script>
<script src="https://unpkg.com/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script src="/static/js/list.js"></script>
</body>
</html>
















