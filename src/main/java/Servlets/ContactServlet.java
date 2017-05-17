package Servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Contact;
import HibernateDAO.ContactDAO;

@SuppressWarnings("serial")
public class ContactServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	req.getRequestDispatcher("Contact.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Contact contact=new Contact();
		ContactDAO dao=new ContactDAO();
		String nom=req.getParameter("nom");
		String prenom=req.getParameter("prenom");
		String telephone=req.getParameter("telephone");
		String type=req.getParameter("type");
		String email=req.getParameter("email");

		contact.setNom(nom);
		contact.setPrenom(prenom);
		contact.setTelephone(telephone);
		contact.setType(type);
		contact.setEmail(email);

		dao.saveData(contact);
	
		//PrintWriter out=resp.getWriter();
		//List<Contact> contacts=new ArrayList();
		
		//contacts=dao.selectAllData();
		//req.setAttribute("contacts", contacts);
		
		//doGet(req, resp);
		
		resp.sendRedirect("Contact");
		
	}
}
