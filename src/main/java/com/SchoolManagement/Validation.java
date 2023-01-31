package com.SchoolManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginValidation")
public class Validation extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Priya");
		EntityManager em=emf.createEntityManager();

		String email1=req.getParameter("email");
		String password1=req.getParameter("password");
		
		Query q=em.createQuery("select p from Principal p where p.email=?1 and p.password=?2");
		q.setParameter(1,email1);
		q.setParameter(2,password1);
		
List<Principal> p=q.getResultList();
		
		if(p.size()>0)
		{
			resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter() ;
			pw.write("Validation successfull");
			RequestDispatcher rd=req.getRequestDispatcher("StudentTeacherDetails.html");
			rd.forward(req, resp);
		}
		else
		{
			resp.setContentType("text/html") ;
			PrintWriter pw = resp.getWriter() ;
			pw.write("invalid credentials");
			RequestDispatcher rd=req.getRequestDispatcher("LoginValidation.html");
			rd.forward(req, resp);
	
		}
}

}
