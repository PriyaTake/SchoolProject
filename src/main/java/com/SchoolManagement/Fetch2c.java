
// Fetching the data from Student

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

@WebServlet("/Fetch")
public class Fetch2c extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Priya");
		EntityManager em=emf.createEntityManager();
		
		Student s=em.find(Student.class,1);
		System.out.println(s.getId());
		System.out.println(s.getSname());
		System.out.println(s.getStream());
		System.out.println(s.getFees());
			 
				
			
				
				PrintWriter pw=resp.getWriter();
				pw.write("Fetch");
				
				RequestDispatcher rd=req.getRequestDispatcher("Student.html");
				rd.forward(req, resp);
				

}
}
