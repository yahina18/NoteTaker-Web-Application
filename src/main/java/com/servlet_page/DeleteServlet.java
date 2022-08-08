package com.servlet_page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entites.NoteTaker;
import com.Helper.FactoryProvider;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   try
	   {
		   int noteID = Integer.parseInt(request.getParameter("note_id"));
		   Session s = FactoryProvider.getFactory().openSession();
		   Transaction tx= s.beginTransaction();
		   NoteTaker note = (NoteTaker)s.get(NoteTaker.class, noteID);
		   s.delete(note);
		   tx.commit();
		   s.close();
		   response.sendRedirect("ShowNotes.jsp");
		   
		   
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
