package HibernateDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.hibernate.Transaction;

import Util.HibernateUtil;
import Entity.Contact;

public class ContactDAO {
Session session;
	private Session setSession(){
		Session session=HibernateUtil.getSessionFactory().openSession();
		return session;
	}
	//enregistrer des donnees dans la table categories
	public void saveData(Contact contact){
		session=setSession();
		try{
			session.beginTransaction();
			session.persist(contact);
			session.save(contact);
			session.getTransaction().commit();
		}catch(HibernateException he){
			he.printStackTrace();
			if(session.getTransaction()!=null){
				session.getTransaction().rollback();
			}
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}
	//selectionner la liste des donnees
	@SuppressWarnings("unchecked")
	public List<Contact> selectAllData(){
		List<Contact> contact=new ArrayList<Contact>();
		
		session=setSession();
		try{
			session.beginTransaction();
			
		Query query=session.createQuery("From Contact");

			contact=query.list();
			
			session.getTransaction().commit();
			
			return contact;
		}catch(HibernateException he){
			
			he.printStackTrace();
			if(session.getTransaction()!=null){
				session.getTransaction().rollback();
			}
			
			return null;
		}finally{
			if(session!=null){
				session.close();
			}
		}
		
		
	}
	public Contact getContactById(Integer id){
		Contact contact=null;
		Session session=setSession();
		try{
			session.beginTransaction();
			contact=(Contact)session.get(Contact.class, id);
			session.getTransaction().commit();
			
		}catch(HibernateException he){
			he.printStackTrace();
			if(session.getTransaction()!=null){
				session.getTransaction().rollback();
			}
		}finally{
			if(session!=null){
				session.close();
			}
		}
	
		return contact;
	}
	public void updateContact(Contact contact) {
	    Transaction trns = null;
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        trns = session.beginTransaction();
	        session.update(contact);
	        session.getTransaction().commit();
	    } catch (RuntimeException e) {
	        if (trns != null) {
	            trns.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.flush();
	        session.close();
	    }
	}
}
