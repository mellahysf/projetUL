package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		if(req.getParameter("idS")!=null){
			int id = Integer.parseInt(req.getParameter("idS"));
			ContactDAO cdao = new ContactDAO();
			//System.out.println("aaa");
			cdao.deleteContact(id);
			
			
		}
		
		// afficherContact start :
		List<Contact> contacts=new ArrayList<Contact>();
		ContactDAO CDAO=new ContactDAO();
		contacts=CDAO.selectAllData();	
		// end
		
		
		req.setAttribute("contacts", contacts);
		if(req.getParameter("id")!=null){
			Map cont=new HashMap();
			Contact contact=new Contact();
			
			int id =Integer.parseInt(req.getParameter("id"));
			contact=CDAO.getContactById(Integer.parseInt(req.getParameter("id")));
			cont.put("id", contact.getId());
			cont.put("nom", contact.getNom());
			cont.put("prenom", contact.getPrenom());
			cont.put("type", contact.getType());
			cont.put("email", contact.getEmail());
			cont.put("telephone", contact.getTelephone());
			req.setAttribute("contact", contact);
			req.getRequestDispatcher("modifier.jsp").forward(req, resp);
			
		}
		


		
		

	req.getRequestDispatcher("AfficherContact.jsp").forward(req, resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ContactDAO UDAO=new ContactDAO();
	Contact contact=new Contact();
	
	if(req.getParameter("id")!=null){
		int id = Integer.parseInt(req.getParameter("id"));
		ContactDAO cdao = new ContactDAO();
		cdao.updateContact(id, req.getParameter("nom"), req.getParameter("prenom"), req.getParameter("telephone"), req.getParameter("type"), req.getParameter("email"));
	}
	
	
	//UDAO.updateContact(contact);
	resp.sendRedirect("AfficherContact");

}
	/*
	 * recuperer tous les contacts
	 */
	public List<Contact> afficherContact(){
		List<Contact> contacts=new ArrayList<Contact>();
		ContactDAO CDAO=new ContactDAO();
		contacts=CDAO.selectAllData();
		return contacts;
	}
	
	public void updateContact(HttpServletRequest request){
		
	}

}
