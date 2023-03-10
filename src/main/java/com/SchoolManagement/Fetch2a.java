
// Updating the data of Student.....

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

@WebServlet("/Update")
public class Fetch2a extends HttpServlet {
	
	@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		
		 String id=req.getParameter("id");
			String name=req.getParameter("name");
			String stream=req.getParameter("stream");
			String fees=req.getParameter("fees");
			
			int id1=Integer.parseInt(id);
			int fees1=Integer.parseInt(fees);
			
			Student s=new Student();
			s.setId(id1);
			s.setSname(name);
			s.setStream(stream);
			s.setFees(fees1);
			
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("Priya");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			et.begin();
			em.merge(s);
			et.commit();
			
			PrintWriter pw=resp.getWriter();
			pw.write("Update");
			
			RequestDispatcher rd=req.getRequestDispatcher("Student.html");
			rd.forward(req, resp);
			
	}
}
