package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Contact;
import HibernateDAO.ContactDAO;

@SuppressWarnings("serial")
public class AfficherContactServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Contact> contacts=new ArrayList<Contact>();
		ContactDAO CDAO=new ContactDAO();
		contacts=CDAO.selectAllData();		
		req.setAttribute("contacts", contacts);

	req.getRequestDispatcher("AfficherContact.jsp").forward(req, resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ContactDAO UDAO=new ContactDAO();
	Contact contact=new Contact();
	String nom=req.getParameter("nom");
	String prenom=req.getParameter("prenom");
	String telephone=req.getParameter("telephone");
	String type=req.getParameter("type");
	String email=req.getParameter("email");
	contact.setId(1);
	contact.setNom(nom);
	contact.setPrenom(prenom);
	contact.setTelephone(telephone);
	contact.setType(type);
	contact.setEmail(email);

	UDAO.updateContact(contact);
	resp.sendRedirect("AfficherContact");

}

}
