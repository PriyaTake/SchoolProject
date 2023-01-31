
// Fetching the data From Teacher
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

@WebServlet("/FetchT")
public class Fetch3c extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Priya");
		EntityManager em=emf.createEntityManager();
		
		
		Teacher t=em.find(Teacher.class,1);
		System.out.println(t.getId());
		System.out.println(t.getTname());
		System.out.println(t.getSubject());
		System.out.println(t.getSalary());
			
		   
	
			
			PrintWriter pw=resp.getWriter();
			pw.write("Fetch");
			
			RequestDispatcher rd=req.getRequestDispatcher("Teacher.html");
			rd.forward(req, resp);
			
	
	}
}
