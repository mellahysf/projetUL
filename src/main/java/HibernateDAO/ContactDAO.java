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
	public boolean saveData(Contact contact){
		session=setSession();
		try{
			session.beginTransaction();
			session.persist(contact);
			session.save(contact);
			session.getTransaction().commit();
		}catch(HibernateException he){
			he.printStackTrace();
			if(session.getTransaction()!=null){
				return false;
				//session.getTransaction().rollback();
			}
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return true;
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
	public boolean updateContact(int id , String nom, String prenom , String telephone , String type,String email){
		Contact cat = new Contact() ; 
		Session session = setSession();
		
		try{
			session.beginTransaction();
			cat = session.get(Contact.class, id);
			cat.setId(id);
			cat.setNom(nom);
			cat.setPrenom(prenom);
			cat.setTelephone(telephone);
			cat.setEmail(email);
			cat.setType(type);
			session.update(cat);
			session.getTransaction().commit();
			
			
		}catch(HibernateException hb){
			hb.printStackTrace();
			if(session.getTransaction()!=null){
				return false;
				//session.getTransaction().rollback();
			}
			
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return true;
	}
	public boolean deleteContact(int idA){
		Contact c = null;
		
		Session session = setSession();		
		try{
			session.beginTransaction();
			c = session.get(Contact.class, idA);
			session.delete(c);
			session.getTransaction().commit();
		}catch(HibernateException he){
			System.out.println("ERROR!!");
			if(session.getTransaction()!=null)
				return false;
				//session.getTransaction().rollback();
		}finally{
			if(session!=null){
				try{
					session.close();
				}catch(Exception ex ){
					ex.printStackTrace();
				}
			}
		}
		return true;
	}
	
}
