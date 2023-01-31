package com.SchoolManagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Account")
public class Fetch extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		
	    String name=req.getParameter("name");
		String age=req.getParameter("age");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String number=req.getParameter("number");
		
		int age1=Integer.parseInt(age);
		long number1=Long.parseLong(number);
		
		Principal p=new Principal();
		p.setPname(name);
		p.setEmail(email);
		p.setAge(age1);
		p.setNumber(number1);
		p.setPassword(password);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Priya");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(p);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Account Created");
		
		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		rd.forward(req, resp);
		
		
	}
}
