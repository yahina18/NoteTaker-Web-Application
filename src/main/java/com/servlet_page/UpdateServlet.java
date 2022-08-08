package com.servlet_page;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entites.NoteTaker;
import com.Helper.FactoryProvider;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String content = request.getParameter("Content");
		int noteID = Integer.parseInt(request.getParameter("NoteID").trim());
		Session s = FactoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		NoteTaker Note = s.get(NoteTaker.class,noteID);
		
		Note.setTitle(title);
		Note.setContent(content);
		Note.setAddDate(new Date());
		tx.commit();
		s.close();
		response.sendRedirect("ShowNotes.jsp");
		
	}

}
