<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty name="user" property="userID" />
<jsp:setProperty name="user" property="userPassword" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
<title>탈퇴하기</title>
</head>
<body>
	  <%
			String userID = null;
			if(session.getAttribute("userID")!=null);{
			user.setUserID((String)session.getAttribute("userID"));
				userID = (String) session.getAttribute("userID");
			}

			UserDAO userDAO = new UserDAO();
			int result = userDAO.delete(userID);
			if (result == -1){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('탈퇴에 성공하셨습니다.')");
				script.println("location.href = 'main.jsp'");
				script.println("</script>");
				session.invalidate();
			}
	%>	
	
</body> 
</html>
