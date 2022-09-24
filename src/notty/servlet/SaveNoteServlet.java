package notty.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notty.bean.NoteBean;
import notty.db.Crud;

/**
 * Servlet implementation class SaveNoteServlet
 */
@WebServlet("/SaveNoteServlet")
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String whatsend=request.getParameter("whatsend");
		if(whatsend.equals("list")){
			//response.getWriter().append("Tra poco avrai la tua lista: ").append(request.getContextPath());
			Crud crud=new Crud( );
			ArrayList<NoteBean>noteInDB=new ArrayList<NoteBean>();
			ServletContext sc=request.getSession().getServletContext();
			request.getSession().removeAttribute("NOTES");
			try{
				noteInDB=crud.listNotes();
				request.setAttribute("NOTES", noteInDB);
				RequestDispatcher rd=sc.getRequestDispatcher("/listNote.jsp");
				rd.forward(request, response);
			}catch(SQLException s){
				//TODO: mandare alla pagina error (rendendola più generica)
			}
		
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String whatsend=request.getParameter("whatsend");
		NoteBean note=new NoteBean();
		
		if(whatsend.equals("note")){
			System.out.println("::::::::INFO PASSATE ALLA SERVLET::::::::");
			String title=request.getParameter("title");
			String body = request.getParameter("body");
			note.setBody(body);
			note.setTitle(title);
			Crud crud=new Crud();
			try {
				crud.insertNote(note);
				ServletContext sc=request.getServletContext();
				RequestDispatcher rd=sc.getRequestDispatcher("/insertok.jsp");
				rd.forward(request, response);
				
			} catch (SQLException e) {
				ServletContext sc=request.getServletContext();
				RequestDispatcher rd=sc.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
				
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		
		
		
		//doGet(request, response);
	}

}
