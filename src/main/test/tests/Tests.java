package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import HibernateDAO.ContactDAO;

public class Tests {
	
	private ContactDAO contactDAO;
	
	@Before
	public void beforeTest(){
		contactDAO = new ContactDAO();
	}
	
	@After
	public void afterTest(){
		contactDAO = null;
	}
	
	@Test
	public void updateContactTest(){
		assertEquals("the result must be true", true, contactDAO.updateContact(26, "tester", "tester", "0000000000", "tester", "tester@gmail.com"));
	}

}
