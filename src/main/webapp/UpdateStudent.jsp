<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="com.SchoolManagement.Student"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String id = request.getParameter("id");
	int id1 = Integer.parseInt(id);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Priya");
	EntityManager em = emf.createEntityManager();

    Student s=em.find(Student.class,id1);
 %> 
 <form action="update" method="post">
		id: <input type="text" value="<%=s.getId()%>" name="id">
	    Sname: <input type="text" value="<%=s.getSname()%>" name="sname">
		Stream: <input type="text" value="<%=s.getStream()%>" name="stream">
		Fees: <input type="text" value="<%=s.getFees()%>"name="fees">
		<input type="submit">
	</form>
  
</body>
</html>