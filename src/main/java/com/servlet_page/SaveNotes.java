package com.servlet_page;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entites.NoteTaker;
import com.Helper.FactoryProvider;

/**
 * Servlet implementation class SaveNotes
 */
public class SaveNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveNotes() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String Content = request.getParameter("Content");
		
		NoteTaker note = new NoteTaker(title,Content,new Date());
		//hibernate.save()
		
	        Session s = FactoryProvider.getFactory().openSession();
            Transaction tx = s.beginTransaction();
	        s.save(note);
            tx.commit();
	        PrintWriter pw = response.getWriter();
		    RequestDispatcher rd = request.getRequestDispatcher("Add_Notes.jsp");
		    rd.include(request, response);
		    response.getWriter().println("<h5 style='text-align:center; color:green;'>Note Saved Successfully!!!</h5>");
		     
		    		  
	}
	 
	

}
