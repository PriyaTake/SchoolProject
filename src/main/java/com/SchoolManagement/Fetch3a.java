
// updating the data from teacher

package com.SchoolManagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Update1")
public class Fetch3a extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Priya");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
			
		    String id=req.getParameter("id");
			String name=req.getParameter("name");
			String subject=req.getParameter("subject");
			String salary=req.getParameter("salary");
			
			int id1=Integer.parseInt(id);
			long salary1=Integer.parseInt(salary);
			
				Teacher t=new Teacher();
				t.setId(id1);
				t.setTname(name);
				t.setSubject(subject);
				t.setSalary(salary1);
				
			
			
			et.begin();
			em.merge(t);
			et.commit();
			
			resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter() ;
			pw.write("updated successfully");
			
			RequestDispatcher rd=req.getRequestDispatcher("Teacher.html");
			rd.forward(req, resp);
			
	}
}
